package com.sopt.carrot.presentation.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sopt.carrot.databinding.ActivityHomeBinding
import com.sopt.carrot.util.toast

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapterList: FullJobAdapter
    private val viewModelRecommended by viewModels<RecommendedViewModel>()
    private val viewModelList by viewModels<FullJobViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeRecommend()
        observeFull()

    }


    private fun observeRecommend() {
        viewModelRecommended.getRecommendedJob(
            4L,
            binding.rvHomeCard,
            message = { str -> toast(str) })
    }

    private fun observeFull() {
        viewModelList.getFullJob(
            4L,
            binding.rvHomeList, message = { str -> toast(str) }
        )

    }


}