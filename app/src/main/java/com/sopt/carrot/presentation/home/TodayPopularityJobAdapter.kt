package com.sopt.carrot.presentation.home

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.carrot.databinding.ItemHomeTodayPopularityJobBinding


class TodayPopularityJobAdapter :
    ListAdapter<TodayPopularityJob, TodayPopularityJobAdapter.TodayPopularityJobAdapterViewHolder>(
        diffUtil
    ) {

    class TodayPopularityJobAdapterViewHolder(private val binding: ItemHomeTodayPopularityJobBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: TodayPopularityJob) {
            with(binding) {

                val str1 = data.ranking
                val str2 = data.title
                val spannable = SpannableString("$str1 $str2")
                spannable.setSpan(
                    ForegroundColorSpan(Color.parseColor("#FF8A3D")),
                    0,
                    str1.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                tvItemHomeTodayPopularityJobTitle.text = spannable
                tvItemHomeTodayPopularityJobDetail.text = data.detail
                tvItemHomeTodayPopularityJobInterest.text = "관심 " + data.interest
                tvItemHomeTodayPopularityJobCheck.text = "조회 " + data.check
                tvItemHomeTodayPopularityJobSalary.text = data.salary


            }

        }

    }


    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<TodayPopularityJob>() {
            override fun areItemsTheSame(
                oldItem: TodayPopularityJob,
                newItem: TodayPopularityJob
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: TodayPopularityJob,
                newItem: TodayPopularityJob
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodayPopularityJobAdapterViewHolder {
        val binding = ItemHomeTodayPopularityJobBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TodayPopularityJobAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodayPopularityJobAdapterViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }


}



