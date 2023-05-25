package com.sopt.carrot.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.carrot.R
import com.sopt.carrot.data.home.ResponseRecommendDto
import com.sopt.carrot.databinding.ItemHomeRecommendedJobBinding

class RecommendedJobAdapter() :
    ListAdapter<ResponseRecommendDto.Detail.Post, RecommendedJobAdapter.RecommendedJobAdapterViewHolder>(
        diffUtil
    ) {


    class RecommendedJobAdapterViewHolder(private val binding: ItemHomeRecommendedJobBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: ResponseRecommendDto.Detail.Post) {

            with(binding) {
                //사진이 로딩 중 이면 test1 사진 로딩 에러면 test2
                Glide.with(root).load(data.image).placeholder(R.drawable.img_test_1)
                    .error(R.drawable.img_test_2).into(ivItemHomeRecommendedJobImg)
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

    override fun getItemCount(): Int = 4 //추천 알바 리스트는 아이템 4개만

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommendedJobAdapterViewHolder {
        val binding = ItemHomeRecommendedJobBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecommendedJobAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendedJobAdapterViewHolder, position: Int) {
        holder.onBind(getItem(position) as ResponseRecommendDto.Detail.Post)
    }


}