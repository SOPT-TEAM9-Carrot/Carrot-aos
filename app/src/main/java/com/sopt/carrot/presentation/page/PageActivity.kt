package com.sopt.carrot.presentation.page

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sopt.carrot.databinding.ActivityPageBinding

class PageActivity : AppCompatActivity() {
    lateinit var binding: ActivityPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}