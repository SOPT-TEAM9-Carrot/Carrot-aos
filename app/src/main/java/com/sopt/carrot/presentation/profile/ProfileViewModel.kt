package com.sopt.carrot.presentation.profile

import androidx.lifecycle.*

class ProfileViewModel : ViewModel() {

    val phoneNumber = MutableLiveData<String>()
    val birthYear = MutableLiveData<String>()
    private val _isButtonEnabled = MediatorLiveData<Boolean>()
    val isButtonEnabled: LiveData<Boolean>
        get() = _isButtonEnabled
    val selectedGender = MutableLiveData<Int>()

    val phoneNumberValidation = phoneNumber.map { phoneNumber ->
        validatePhoneNumber(phoneNumber)
    }

    val birthYearValidation = birthYear.map { birthYear ->
        validateBirthYear(birthYear)
    }

    init {
        _isButtonEnabled.value = false
        selectedGender.value = 1

        _isButtonEnabled.addSource(phoneNumberValidation) { validateForm() }
        _isButtonEnabled.addSource(birthYearValidation) { validateForm() }
    }

    private fun validatePhoneNumber(phoneNumber: String?): Boolean {
        return !phoneNumber.isNullOrBlank() && phoneNumber!!.length == 11
    }

    private fun validateBirthYear(birthYear: String?): Boolean {
        return !birthYear.isNullOrBlank() && birthYear!!.length == 4
    }

    private fun validateForm() {
        _isButtonEnabled.value = phoneNumberValidation.value ?: false && birthYearValidation.value ?: false
    }

}
