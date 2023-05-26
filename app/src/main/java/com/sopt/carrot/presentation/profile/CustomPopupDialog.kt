package com.sopt.carrot.presentation.profile

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import com.sopt.carrot.databinding.LayoutProfileCustompopupBinding
import com.sopt.carrot.presentation.page.PageActivity

class CustomPopupDialog(context: Context) : Dialog(context) {

    private val binding: LayoutProfileCustompopupBinding by lazy {
        LayoutProfileCustompopupBinding.inflate(layoutInflater)
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
        binding.btnProfilePopupExit.setOnClickListener {
            //dismiss()
            val intent = Intent(context, PageActivity::class.java)
            context.startActivity(intent)
        }
    }
}

