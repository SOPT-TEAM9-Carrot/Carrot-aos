package com.sopt.carrot.presentation.page

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.carrot.data.ApiPool
import com.sopt.carrot.data.page.PageResponse
import retrofit2.Call
import retrofit2.Response

class PageViewModel : ViewModel() {
    private val _pageResponse: MutableLiveData<PageResponse> = MutableLiveData()
    val pageResponse: LiveData<PageResponse> = _pageResponse

    fun getPageDetail(pageId: Long, logging: (String) -> Unit ) {
        ApiPool.pageService.getPage(pageId).enqueue(object : retrofit2.Callback<PageResponse> {
            override fun onResponse(call: Call<PageResponse>, response: Response<PageResponse>) {
                if (response.isSuccessful) { // 200
                    _pageResponse.value = response.body()
                }
                else {
                    logging.invoke("response error")
                }
            }

            override fun onFailure(call: Call<PageResponse>, t: Throwable) {

                logging.invoke("network error")
            }
        })
    }

}