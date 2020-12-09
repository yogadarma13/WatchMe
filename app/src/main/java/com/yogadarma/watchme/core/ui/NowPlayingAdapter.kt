package com.yogadarma.watchme.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yogadarma.watchme.R
import com.yogadarma.watchme.core.domain.model.Movie
import com.yogadarma.watchme.databinding.ItemNowPlayingBinding
import java.util.ArrayList

class NowPlayingAdapter : RecyclerView.Adapter<NowPlayingAdapter.ViewHolder>() {

    private var listData = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    fun setData(newListData: List<Movie>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_now_playing, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ItemNowPlayingBinding.bind(itemView)

        fun bind(data: Movie) {
            with(binding) {
                tvTitleNowPlaying.text = data.title
                tvReleaseDateNowPlaying.text = data.releaseDate
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}