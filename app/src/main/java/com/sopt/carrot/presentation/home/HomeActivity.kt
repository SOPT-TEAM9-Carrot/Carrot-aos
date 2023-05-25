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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeRecommend()
        observeFull()
        setTodayPopularityJobAdapter()

    }


    private fun observeRecommend() {
        viewModelRecommended.getRecommendedJob(
            4L,
            binding.rvHomeRecommend,
            message = { str -> toast(str) })
    }

    private fun observeFull() {
        viewModelList.getFullJob(
            4L,
            binding.rvHomeSelectList, message = { str -> toast(str) }
        )

    }

    private fun setTodayPopularityJobAdapter() {
        adapter = TodayPopularityJobAdapter()
        binding.rvHomeTodayPopularity.adapter = adapter
        adapter.submitList(viewModelPopularity.mockTodayPopularityJobLists)

    }


}