package com.project.listnavigationcomponent.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.project.listnavigationcomponent.databinding.ItemBtnRowBinding

class TextAdapter : ListAdapter<String, TextAdapter.MovieViewHolder>(Diff()) {
    var onBtnClick: ((String) -> Unit)? = null

    override fun onBindViewHolder(viewHolder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        movie?.let {
            viewHolder.binds(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemBtnRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class MovieViewHolder(private val binding: ItemBtnRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binds(text: String) {
            binding.apply {
                btnText.text = text
                btnText.setOnClickListener {
                    onBtnClick?.invoke(text)
                }
            }
        }
    }

    class Diff : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean =
            oldItem == newItem
    }
}
