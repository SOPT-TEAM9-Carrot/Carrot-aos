package com.sopt.carrot.presentation.review.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.carrot.data.ResponseReviewDto


class ReviewViewModel : ViewModel() {

    //통신 변수 준비
    private val _signUpResult: MutableLiveData<ResponseReviewDto> = MutableLiveData()
    val signUpResult: LiveData<ResponseReviewDto> = _signUpResult

    private val _errorResult: MutableLiveData<ResponseReviewDto> = MutableLiveData()
    val errorResult: LiveData<ResponseReviewDto> = _errorResult

    //더미 데이터
    private var _reviews: MutableLiveData<List<ResponseReviewDto.Data.Review>> = MutableLiveData(listOf(
        ResponseReviewDto.Data.Review("comment1", "img1", "name1"),
        ResponseReviewDto.Data.Review("comment2", "img2", "name2"),
        ResponseReviewDto.Data.Review("comment3", "img3", "name3"),
        ResponseReviewDto.Data.Review("comment4", "img4", "name4"),
        ResponseReviewDto.Data.Review("comment5", "img6", "name6"),
        ResponseReviewDto.Data.Review("comment6", "img7", "name7"),
        ResponseReviewDto.Data.Review("comment7", "img8", "name8")
    ))

    val reviews: LiveData<List<ResponseReviewDto.Data.Review>> = _reviews
}