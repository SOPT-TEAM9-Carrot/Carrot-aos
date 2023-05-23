package com.sopt.carrot.presentation.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sopt.carrot.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapterCard: RecommendedJobAdapter
    private lateinit var adapterList: FullJobAdapter
    private val viewModelCard by viewModels<RecommendedViewModel>()
    private val viewModelList by viewModels<FullJobViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAdapter()

    }

    private fun setAdapter() {
        adapterCard = RecommendedJobAdapter()
        binding.rvHomeCard.adapter = adapterCard
        adapterCard.submitList(viewModelCard.mockRecommendedJobLists)
        adapterList = FullJobAdapter()
        binding.rvHomeList.adapter = adapterList
        adapterList.submitList(viewModelList.mockListLists)
    }


}