package com.sopt.carrot.presentation.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sopt.carrot.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapterCard: CardAdapter
    private lateinit var adapterList: JobAdapter
    private val viewModelCard by viewModels<CardViewModel>()
    private val viewModelList by viewModels<ListViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAdapter()

    }

    private fun setAdapter() {
        adapterCard = CardAdapter()
        binding.rvHomeCard.adapter = adapterCard
        adapterCard.submitList(viewModelCard.mockCardLists)
        adapterList = JobAdapter()
        binding.rvHomeList.adapter = adapterList
        adapterList.submitList(viewModelList.mockListLists)
    }


}