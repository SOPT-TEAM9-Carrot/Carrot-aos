package com.sopt.carrot.presentation.review.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.sopt.carrot.data.review.ResponseReviewDto
import com.sopt.carrot.databinding.ItemReviewBinding

class ReviewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var itemList: List<ResponseReviewDto.Data.Review> = listOf()

    class ReviewViewHolder(
        private val binding: ItemReviewBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemList: ResponseReviewDto.Data.Review) {
            with(binding) {
                tvReviewName.text = itemList.reviewerName
                tvReviewReview.text = itemList.comment
                imgReivewProfile.load(itemList.imageUrl) {
                    transformations(CircleCropTransformation())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ReviewViewHolder) {
            holder.bind(itemList[position])
        }
    }

    override fun getItemCount() = itemList.size

    fun updateList(newList: List<ResponseReviewDto.Data.Review>) {
        itemList = newList
        notifyDataSetChanged()
    }
}
