package com.sopt.carrot.presentation.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sopt.carrot.databinding.ActivityHomeBinding
import com.sopt.carrot.util.toast

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: TodayPopularityJobAdapter
    private val viewModelPopularity by viewModels<TodayPopularityJobViewModel>()
    private val viewModelRecommended by viewModels<RecommendedViewModel>()
    private val viewModelList by viewModels<FullJobViewModel>()
    private val jobDataCount: Long = 8L


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecommendView()
        setSelectView()
        setFullView()
        setTodayPopularityJobAdapter()
        pressShuffleButton()

    }


    //알바 추천 리스트 조회 서버 통신 함수
    private fun setRecommendView() {
        viewModelRecommended.getRecommendedJob(
            jobDataCount,
            binding.rvHomeRecommend,
            message = { str -> toast(str) })
    }

    //알바 리스트 조회 서버 통신 함수(3개만 뽑아서)
    private fun setSelectView() {
        viewModelList.getFullJob(
            jobDataCount,
            binding.rvHomeSelectList, message = { str -> toast(str) }, 1
        )

    }

    //알바 리스트 조회 서버 통신 함수(전체)
    private fun setFullView() {
        viewModelList.getFullJob(
            jobDataCount,
            binding.rvHomeFull, message = { str -> toast(str) }, 2
        )

    }


    //오늘의 인기 알바 리사이클러뷰 어댑터 연결 함수
    private fun setTodayPopularityJobAdapter() {
        adapter = TodayPopularityJobAdapter()
        binding.rvHomeTodayPopularity.adapter = adapter
        adapter.submitList(viewModelPopularity.mockTodayPopularityJobLists)

    }

    //알바 추천 리스트 셔플 함수
    private fun pressShuffleButton() {
        binding.btnHomeShuffle.setOnClickListener {
            viewModelRecommended.shuffleRecommendedJob(
                jobDataCount,
                binding.rvHomeRecommend,
                message = { str -> toast(str) })

        }
    }


}