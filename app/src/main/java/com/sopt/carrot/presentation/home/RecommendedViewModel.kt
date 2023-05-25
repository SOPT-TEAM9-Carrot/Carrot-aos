package com.sopt.carrot.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.sopt.carrot.data.ApiPool
import com.sopt.carrot.data.home.ResponseRecommendDto
import com.sopt.carrot.util.enqueueUtil
import java.util.*

class RecommendedViewModel : ViewModel() {
    private val _recommendedJobResponse: MutableLiveData<ResponseRecommendDto> = MutableLiveData()
    val recommendedJobResponse: LiveData<ResponseRecommendDto> = _recommendedJobResponse

    fun getRecommendedJob(size: Long, recyclerView: RecyclerView, message: (String) -> Unit) {
        ApiPool.recommendService.getRecommendJobList(1, size).enqueueUtil(
            onSuccess = {
                _recommendedJobResponse.value = it
                recyclerView.adapter = RecommendedJobAdapter().apply { submitList(it.data.posts) }
                message.invoke(it.message)

            },
            onError = {
                message.invoke("error:${it}")
            }
        )


    }


    fun shuffleRecommendedJob(size: Long, recyclerView: RecyclerView, message: (String) -> Unit) {
        ApiPool.recommendService.getRecommendJobList(1, size).enqueueUtil(
            onSuccess = {
                _recommendedJobResponse.value = it
                val data: List<ResponseRecommendDto.Detail.Post> = it.data.posts
                Collections.shuffle(data)
                recyclerView.adapter = RecommendedJobAdapter().apply { submitList(data) }
                message.invoke(it.message)

            },
            onError = {
                message.invoke("error:${it}")
            }
        )

    }


}