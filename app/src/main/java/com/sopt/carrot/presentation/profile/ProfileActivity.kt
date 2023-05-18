package com.sopt.carrot.presentation.profile

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.sopt.carrot.R
import com.sopt.carrot.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private val viewModel: ProfileViewModel by viewModels()
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this // lifecycleOwner 설정

        with(binding) {
            // 초기값
            btnProfileWoman.isSelected = true
            btnProfileWoman.setTextColor(ContextCompat.getColor(applicationContext, R.color.white))
            btnProfileAgreeAndApply.isEnabled = false
        }

        // introductionTextCount 업데이트
        viewModel.introductionTextCount.observe(this, { textCount ->
            binding.tvProfileIntroductionTextCount.text = textCount
        })

        // isButtonEnabled 업데이트
        viewModel.isButtonEnabled.observe(this, { isEnabled ->
            binding.btnProfileAgreeAndApply.isEnabled = isEnabled
        })

        setupClickListeners()
    }

    private fun setupClickListeners() {
        with(binding) {
            btnProfileMan.setOnClickListener {
                it.isSelected = true
                btnProfileMan.setTextColor(ContextCompat.getColor(applicationContext,R.color.white))
                btnProfileWoman.setTextColor(ContextCompat.getColor(applicationContext,R.color.color_sub_gray3))
                btnProfileWoman.isSelected = false
                viewModel?.selectedGender?.value = 0
            }
            btnProfileWoman.setOnClickListener {
                it.isSelected = true
                btnProfileWoman.setTextColor(ContextCompat.getColor(applicationContext,R.color.white))
                btnProfileMan.setTextColor(ContextCompat.getColor(applicationContext,R.color.color_sub_gray3))
                btnProfileMan.isSelected = false
                viewModel?.selectedGender?.value = 1
            }
        }
    }
}
