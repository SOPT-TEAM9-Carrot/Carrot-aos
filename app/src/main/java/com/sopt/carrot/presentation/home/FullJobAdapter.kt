package com.sopt.carrot.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.carrot.data.home.ResponseFullListDto
import com.sopt.carrot.databinding.ItemHomeFullJobBinding

class FullJobAdapter(state: Int) :
    ListAdapter<ResponseFullListDto.Detail.Post, FullJobAdapter.JobAdapterViewHolder>(diffUtil) {
    private val recyclerViewDivision: Int = state

    class JobAdapterViewHolder(private val binding: ItemHomeFullJobBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: ResponseFullListDto.Detail.Post) {
            with(binding) {
                Glide.with(root).load(data.image).into(ivItemHomeFullJobImg)
                tvItemHomeFullJobTitle.text = data.title
                tvItemHomeFullJobTitle.text = data.title
                tvItemHomeFullJobSalary.text = "시급 " + data.hourlyWage.toString() + "만원"
            }

        }


    }


    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ResponseFullListDto.Detail.Post>() {
            override fun areItemsTheSame(
                oldItem: ResponseFullListDto.Detail.Post,
                newItem: ResponseFullListDto.Detail.Post
            ): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(
                oldItem: ResponseFullListDto.Detail.Post,
                newItem: ResponseFullListDto.Detail.Post
            ): Boolean {
                return oldItem == newItem
            }

        }
    }


    override fun getItemCount(): Int {
        return if (recyclerViewDivision == 1) {
            3
        } else {
            super.getItemCount()
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
        holder.onBind(getItem(position) as ResponseFullListDto.Detail.Post)
    }
}