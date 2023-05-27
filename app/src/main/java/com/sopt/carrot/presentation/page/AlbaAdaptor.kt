package com.sopt.carrot.presentation.page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sopt.carrot.data.page.AlbaResponse
import com.sopt.carrot.databinding.ItemHomeFullJobBinding

class AlbaAdaptor() :
    ListAdapter<AlbaResponse.Detail.Post, AlbaAdaptor.JobAdapterViewHolder>(diffUtil) {

    class JobAdapterViewHolder(private val binding: ItemHomeFullJobBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: AlbaResponse.Detail.Post) {
            with(binding) {
                ivItemHomeFullJobImg.load(data.image)
                tvItemHomeFullJobTitle.text = data.title
                tvItemHomeFullJobSalary.text = "시급 " + data.hourlyWage.toString() + "만원"
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<AlbaResponse.Detail.Post>() {
            override fun areItemsTheSame(
                oldItem: AlbaResponse.Detail.Post,
                newItem: AlbaResponse.Detail.Post
            ): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(
                oldItem: AlbaResponse.Detail.Post,
                newItem: AlbaResponse.Detail.Post
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun getItemCount(): Int = 3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobAdapterViewHolder {
        val binding = ItemHomeFullJobBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return JobAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobAdapterViewHolder, position: Int) {
        holder.onBind(getItem(position) as AlbaResponse.Detail.Post)
    }
}