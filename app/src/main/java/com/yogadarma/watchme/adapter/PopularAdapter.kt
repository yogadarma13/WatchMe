package com.yogadarma.watchme.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.utils.DateFormat
import com.yogadarma.watchme.R
import com.yogadarma.watchme.databinding.ItemPopularBinding
import java.util.*

class PopularAdapter : RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    private var listData = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    fun setData(newListData: List<Movie>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_popular, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPopularBinding.bind(itemView)

        fun bind(data: Movie) {
            with(binding) {
                Glide.with(binding.root)
                    .load("https://image.tmdb.org/t/p/w220_and_h330_face${data.image}").apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    ).centerCrop().into(imgPosterPopular)
                tvTitlePopular.text = data.title
                tvReleaseDatePopular.text = DateFormat.format(data.releaseDate)
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}