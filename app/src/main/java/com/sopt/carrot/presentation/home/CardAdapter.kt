package com.sopt.carrot.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.carrot.databinding.ItemHomeCardBinding

class CardAdapter() : ListAdapter<Card, CardAdapter.CardAdapterViewHolder>(diffUtil) {


    class CardAdapterViewHolder(private val binding: ItemHomeCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: Card) {
            with(binding) {
                ivItemHomeCardImg.setImageDrawable(root.context.getDrawable(data.image))
                tvItemHomeCardTitle.text = data.title
                tvItemHomeCardSalary.text = data.salary
            }

        }

    }


    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Card>() {
            override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapterViewHolder {
        val binding = ItemHomeCardBinding.inflate(
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