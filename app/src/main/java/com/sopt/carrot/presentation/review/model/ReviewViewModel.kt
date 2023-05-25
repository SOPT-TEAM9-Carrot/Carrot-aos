package com.sopt.carrot.presentation.review.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.carrot.data.ApiPool
import com.sopt.carrot.data.review.ResponseReviewDto
import com.sopt.carrot.util.enqueueUtil

class ReviewViewModel : ViewModel() {

    private val _reviews: MutableLiveData<List<ResponseReviewDto.Data.Review>> = MutableLiveData()
    val reviews: LiveData<List<ResponseReviewDto.Data.Review>> get() = _reviews

    private val _signUpResult: MutableLiveData<ResponseReviewDto> = MutableLiveData()
    val signUpResult: LiveData<ResponseReviewDto> = _signUpResult

    private val _errorResult: MutableLiveData<ResponseReviewDto> = MutableLiveData()
    val errorResult: LiveData<ResponseReviewDto> = _errorResult

    fun getReview(userId: Long) {
        val reviewService = ApiPool.reviewService
        reviewService.getReviewList(userId).enqueueUtil(
            onSuccess = { response ->
                val data = response.data?.reviews
                _reviews.value = data!!
                _signUpResult.value = response
            },
            onError = { stateCode ->
                Log.d("Error", "Error occurred with stateCode: $stateCode")
            }
        )
    }


}
