package com.sopt.carrot.presentation.review.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.carrot.data.ApiPool
import com.sopt.carrot.data.review.ResponseReviewDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewViewModel : ViewModel() {

    private val _reviews: MutableLiveData<List<ResponseReviewDto.Data.Review>> = MutableLiveData()
    val reviews: LiveData<List<ResponseReviewDto.Data.Review>> get() = _reviews

    private val _signUpResult: MutableLiveData<ResponseReviewDto> = MutableLiveData()
    val signUpResult: LiveData<ResponseReviewDto> = _signUpResult

    private val _errorResult: MutableLiveData<ResponseReviewDto> = MutableLiveData()
    val errorResult: LiveData<ResponseReviewDto> = _errorResult

    init {
        getReview()
    }

    fun getReview() {
        val reviewService = ApiPool.reviewService
        reviewService.getReviewList().enqueue(object : Callback<ResponseReviewDto> {
            override fun onResponse(
                call: Call<ResponseReviewDto>,
                response: Response<ResponseReviewDto>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data?.reviews
                    _reviews.value = data!!
                    _signUpResult.value = response.body()
                } else {
                    // handle failure
                    _errorResult.value = response.body()
                }
            }

            override fun onFailure(call: Call<ResponseReviewDto>, t: Throwable) {
                _errorResult.value = (t.localizedMessage ?: "Unknown error") as ResponseReviewDto?
            }
        })
    }

}
