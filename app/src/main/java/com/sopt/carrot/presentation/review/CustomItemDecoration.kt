package com.sopt.carrot.presentation.review

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.sopt.carrot.R

class CustomItemDecoration(): RecyclerView.ItemDecoration() {
    @SuppressLint("ResourceAsColor")
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val widthMargin = 45f   // 좌우 Margin
        val height = 0.5f         // 사각형의 height

        val left = parent.paddingLeft.toFloat()
        val right = parent.width - parent.paddingRight.toFloat()
        val paint = Paint().apply { color = R.color.color_sub_gray6 }
        for(i in 0 until parent.childCount -1 ) { // 1개 혹은 0개는 나오지 않음
            val view = parent.getChildAt(i)
            val top = view.bottom.toFloat() + (view.layoutParams as RecyclerView.LayoutParams).bottomMargin
            val bottom = top + height   // 세로 길이 = 5 (bottom - top = height)

            // 좌표 (left, top) / (right, bottom) 값을 대각선으로 가지는 사각형
            c.drawRect(left + widthMargin, top, right - widthMargin, bottom, paint)
        }
    }
}