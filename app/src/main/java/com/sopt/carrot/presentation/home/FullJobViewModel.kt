package com.sopt.carrot.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.sopt.carrot.data.ApiPool
import com.sopt.carrot.data.home.ResponseFullListDto
import com.sopt.carrot.data.home.ResponseRecommendDto
import com.sopt.carrot.util.enqueueUtil

class FullJobViewModel : ViewModel() {
    private val _fullJobResponse: MutableLiveData<ResponseFullListDto> = MutableLiveData()
    val fullJobResponse: LiveData<ResponseFullListDto> = _fullJobResponse

    fun getFullJob(size: Long, recyclerView: RecyclerView, message: (String) -> Unit) {
        ApiPool.fullListService.getFullJobList(1, size).enqueueUtil(
            onSuccess = {
                _fullJobResponse.value = it
                recyclerView.adapter = FullJobAdapter().apply { submitList(it.data.posts) }
                message.invoke(it.message)

            },
            onError = {
                message.invoke("error:${it}")
            }
        )


    }

}