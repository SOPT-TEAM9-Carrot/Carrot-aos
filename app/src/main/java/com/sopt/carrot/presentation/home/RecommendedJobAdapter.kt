package com.sopt.carrot.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.carrot.databinding.ItemHomeRecommendedJobBinding

class RecommendedJobAdapter() :
    ListAdapter<RecommendedJob, RecommendedJobAdapter.CardAdapterViewHolder>(diffUtil) {


    class CardAdapterViewHolder(private val binding: ItemHomeRecommendedJobBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: RecommendedJob) {
            with(binding) {
                ivItemHomeRecommendedJobImg.setImageDrawable(root.context.getDrawable(data.image))
                tvItemHomeRecommendedJobTitle.text = data.title
                tvItemHomeRecommendedJobSalary.text = data.salary
            }

        }

    }


    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RecommendedJob>() {
            override fun areItemsTheSame(
                oldItem: RecommendedJob,
                newItem: RecommendedJob
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: RecommendedJob,
                newItem: RecommendedJob
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapterViewHolder {
        val binding = ItemHomeRecommendedJobBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CardAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardAdapterViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }


}