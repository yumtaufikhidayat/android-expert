package com.yumtaufikhidayat.tourismapp.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yumtaufikhidayat.tourismapp.core.databinding.ItemListTourismBinding
import com.yumtaufikhidayat.tourismapp.core.domain.model.Tourism
import com.yumtaufikhidayat.tourismapp.core.utils.loadImage

class TourismAdapter(
    private val onItemClickListener: (Tourism) -> Unit
) : ListAdapter<Tourism, TourismAdapter.TourismViewHolder>(tourismDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourismViewHolder {
        return TourismViewHolder(
            ItemListTourismBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TourismViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TourismViewHolder(private val binding: ItemListTourismBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Tourism) {
            binding.apply {
                ivItemImage.loadImage(itemView.context, data.image)
                tvItemTitle.text = data.name
                tvItemSubtitle.text = data.address
                itemView.setOnClickListener {
                    onItemClickListener.invoke(data)
                }
            }
        }
    }

    companion object {
        val tourismDiffCallback = object : DiffUtil.ItemCallback<Tourism>() {
            override fun areItemsTheSame(oldItem: Tourism, newItem: Tourism): Boolean {
                return oldItem.tourismId == newItem.tourismId
            }

            override fun areContentsTheSame(oldItem: Tourism, newItem: Tourism): Boolean {
                return oldItem == newItem
            }
        }
    }
}
