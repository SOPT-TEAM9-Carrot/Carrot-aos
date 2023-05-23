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
        setAdapter()
        observe()

    }

    private fun setAdapter() {
        adapterList = FullJobAdapter()
        binding.rvHomeList.adapter = adapterList
        adapterList.submitList(viewModelList.mockListLists)
    }


    private fun observe() {
        viewModelRecommended.getRecommendedJob(
            4L,
            binding.rvHomeCard,
            message = { str -> toast(str) })
    }


}