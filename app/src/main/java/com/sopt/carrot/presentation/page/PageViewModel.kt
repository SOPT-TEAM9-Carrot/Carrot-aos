package com.sopt.carrot.presentation.page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.sopt.carrot.data.ApiPool
import com.sopt.carrot.data.page.AlbaResponse
import com.sopt.carrot.data.page.PageResponse
import com.sopt.carrot.data.review.ResponseReviewDto
import com.sopt.carrot.util.enqueueUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PageViewModel : ViewModel() {
    private val _pageResponse: MutableLiveData<PageResponse> = MutableLiveData()
    val pageResponse: LiveData<PageResponse> = _pageResponse

    private val _reviews: MutableLiveData<List<ResponseReviewDto.Data.Review>> = MutableLiveData()
    val reviews: LiveData<List<ResponseReviewDto.Data.Review>> get() = _reviews

    private val _alba: MutableLiveData<AlbaResponse> = MutableLiveData()
    val alba: LiveData<AlbaResponse> get() = _alba

    internal fun getPageDetail(pageId: Long, logging: (String) -> Unit) {
        ApiPool.pageService.getPage(1, pageId).enqueue(object : retrofit2.Callback<PageResponse> {
            override fun onResponse(call: Call<PageResponse>, response: Response<PageResponse>) {
                if (response.isSuccessful) { // 200
                    _pageResponse.value = response.body()
                } else {
                    logging.invoke("response error")
                }
            }

            override fun onFailure(call: Call<PageResponse>, t: Throwable) {
                logging.invoke("network error")
            }
        })
    }

    internal fun getReviews(logging: (String) -> Unit) {
        ApiPool.reviewService.getReviewList(getUserId())
            .enqueue(object : Callback<ResponseReviewDto> {
                override fun onResponse(
                    call: Call<ResponseReviewDto>,
                    response: Response<ResponseReviewDto>
                ) {
                    if (response.isSuccessful) {
                        _reviews.value = response.body()?.data?.reviews
                    } else {
                        logging.invoke("리뷰 조회 실패")
                    }
                }

                override fun onFailure(call: Call<ResponseReviewDto>, t: Throwable) {
                    logging.invoke("network error")
                }
            })
    }

    internal fun getAlba(rc: RecyclerView) {
        ApiPool.pageService.getAlba(1, 3).enqueueUtil(
            onSuccess = {
                _alba.value = it
                rc.adapter = AlbaAdaptor().apply { submitList(it.data.posts) }
            }
        )
    }

    internal fun getUserId() = 1L
}