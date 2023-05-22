package com.sopt.carrot.presentation.profile

import android.util.Log
import androidx.lifecycle.*
import com.sopt.carrot.data.ApiPool.profileService
import com.sopt.carrot.data.profile.RequestProfileDto
import com.sopt.carrot.data.profile.ResponseProfileDto
import retrofit2.Call
import retrofit2.Response

class ProfileViewModel : ViewModel() {

    val phoneNumber = MutableLiveData<String>()
    val birthYear = MutableLiveData<String>()

    private val _isButtonEnabled = MediatorLiveData<Boolean>()
    val isButtonEnabled: LiveData<Boolean>
        get() = _isButtonEnabled

    val selectedGender = MutableLiveData<Int>()
    val name = MutableLiveData<String>()
    val introduction = MutableLiveData<String>()

    val phoneNumberValidation = phoneNumber.map { phoneNumber ->
        validatePhoneNumber(phoneNumber)
    }

    val birthYearValidation = birthYear.map { birthYear ->
        validateBirthYear(birthYear)
    }

    val introductionTextCount: LiveData<String> = MediatorLiveData<String>().apply {
        addSource(introduction) { text ->
            value = "${text?.length ?: 0}/2000"
        }
    }

    init {
        _isButtonEnabled.value = false
        selectedGender.value = 1
        introduction.value = ""
        _isButtonEnabled.addSource(phoneNumberValidation) { validateForm() }
        _isButtonEnabled.addSource(birthYearValidation) { validateForm() }
    }

    private fun validatePhoneNumber(phoneNumber: String?): Boolean {
        return !phoneNumber.isNullOrBlank() && phoneNumber!!.length == 11
    }

    private fun validateBirthYear(birthYear: String?): Boolean {
        return !birthYear.isNullOrBlank() && birthYear.length == 4
    }

    private fun validateForm() {
        _isButtonEnabled.value =
            phoneNumberValidation.value ?: false && birthYearValidation.value ?: false
    }

    fun applyToServer() {
        val birthYearInt = birthYear.value?.toIntOrNull()
        val phoneNumberValue = phoneNumber.value
        if (birthYearInt != null && validateBirthYear(birthYearInt.toString()) && !phoneNumberValue.isNullOrBlank()) {
            // 유효한 값인 경우에만 API 호출
            profileService.apply(
                RequestProfileDto(
                    birthYearInt,
                    selectedGender.value ?: 0,
                    introduction.value,
                    name.value,
                    phoneNumberValue
                )
            ).enqueue(object : retrofit2.Callback<ResponseProfileDto> {
                override fun onResponse(
                    call: Call<ResponseProfileDto>,
                    response: Response<ResponseProfileDto>,
                ) {
                    if (response.isSuccessful) {
                        Log.d("통신 성공", response.body()?.data.toString())
                    } else {
                        Log.d("통신 실패", response.errorBody()?.string() ?: "Unknown error")
                    }
                }

                override fun onFailure(call: Call<ResponseProfileDto>, t: Throwable) {
                    Log.d("통신 실패", t.localizedMessage ?: "Unknown error")
                }
            })
        }
    }
}