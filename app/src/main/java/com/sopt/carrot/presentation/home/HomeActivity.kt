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
        observeRecommend()
        observeSelect()
        observeFull()
        setTodayPopularityJobAdapter()

    }


    private fun observeRecommend() {
        viewModelRecommended.getRecommendedJob(
            jobDataCount,
            binding.rvHomeRecommend,
            message = { str -> toast(str) })
    }

    private fun observeSelect() {
        viewModelList.getFullJob(
            jobDataCount,
            binding.rvHomeSelectList, message = { str -> toast(str) }, 1
        )

    }

    private fun observeFull() {
        viewModelList.getFullJob(
            jobDataCount,
            binding.rvHomeFull, message = { str -> toast(str) }, 2
        )

    }


    private fun setTodayPopularityJobAdapter() {
        adapter = TodayPopularityJobAdapter()
        binding.rvHomeTodayPopularity.adapter = adapter
        adapter.submitList(viewModelPopularity.mockTodayPopularityJobLists)

    }


}