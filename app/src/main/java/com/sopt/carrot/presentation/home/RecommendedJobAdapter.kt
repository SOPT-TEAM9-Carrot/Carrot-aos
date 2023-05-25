package com.sopt.carrot.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.carrot.data.home.ResponseRecommendDto
import com.sopt.carrot.databinding.ItemHomeRecommendedJobBinding

class RecommendedJobAdapter() :
    ListAdapter<ResponseRecommendDto.Detail.Post, RecommendedJobAdapter.CardAdapterViewHolder>(
        diffUtil
    ) {


    class CardAdapterViewHolder(private val binding: ItemHomeRecommendedJobBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: ResponseRecommendDto.Detail.Post) {
            with(binding) {
                Glide.with(root).load(data.image).into(ivItemHomeRecommendedJobImg)
                tvItemHomeRecommendedJobTitle.text = data.title
                tvItemHomeRecommendedJobSalary.text = "월급 " + data.monthlyWage.toString() + "만원"
            }

        }

    }


    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ResponseRecommendDto.Detail.Post>() {
            override fun areItemsTheSame(
                oldItem: ResponseRecommendDto.Detail.Post,
                newItem: ResponseRecommendDto.Detail.Post
            ): Boolean {
                return oldItem.postId == newItem.postId
            }

            override fun areContentsTheSame(
                oldItem: ResponseRecommendDto.Detail.Post,
                newItem: ResponseRecommendDto.Detail.Post
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun getItemCount(): Int = 4

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapterViewHolder {
        val binding = ItemHomeRecommendedJobBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CardAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardAdapterViewHolder, position: Int) {
        holder.onBind(getItem(position) as ResponseRecommendDto.Detail.Post)
    }


}