package com.sopt.carrot.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.carrot.databinding.ItemHomeFullJobBinding

class FullJobAdapter() :
    ListAdapter<RecommendedJob, FullJobAdapter.JobAdapterViewHolder>(diffUtil) {

    class JobAdapterViewHolder(private val binding: ItemHomeFullJobBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: RecommendedJob) {
            with(binding) {
                ivItemHomeFullJobImg.setImageDrawable(root.context.getDrawable(data.image))
                tvItemHomeFullJobTitle.text = data.title
                tvItemHomeFullJobTitle.text = data.salary
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobAdapterViewHolder {
        val binding = ItemHomeFullJobBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return JobAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobAdapterViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}