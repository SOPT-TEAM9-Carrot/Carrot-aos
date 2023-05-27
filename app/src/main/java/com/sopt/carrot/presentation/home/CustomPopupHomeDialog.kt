package com.sopt.carrot.presentation.home

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import com.sopt.carrot.databinding.LayoutHomeCustompopupBinding

class CustomPopupHomeDialog(context: Context) : Dialog(context) {
    private val binding: LayoutHomeCustompopupBinding by lazy {
        LayoutHomeCustompopupBinding.inflate(layoutInflater)
    }


    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)

        window?.apply {
            setBackgroundDrawable(ColorDrawable(Color.parseColor("#80000000")))
            setGravity(Gravity.CENTER)
            setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }

        setCanceledOnTouchOutside(true)
        binding.btnProfilePopupCancel.setOnClickListener { dismiss() }

    }
}