package com.sopt.carrot.presentation.home

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.carrot.R
import com.sopt.carrot.data.home.ResponseRecommendDto
import com.sopt.carrot.databinding.ItemHomeRecommendedJobBinding
import com.sopt.carrot.presentation.page.PageActivity

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

            //아이템 클릭 리스너: 알바 상세페이지에 post id 넘겨주기
            binding.root.setOnClickListener {
                val intent = Intent(it.context, PageActivity::class.java)
                intent.putExtra("postId", data.postId.toString())
                Log.d("postId", data.postId.toString())

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