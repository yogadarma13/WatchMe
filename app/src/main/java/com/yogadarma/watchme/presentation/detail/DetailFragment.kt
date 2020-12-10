package com.yogadarma.watchme.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yogadarma.watchme.R
import com.yogadarma.watchme.core.data.Resource
import com.yogadarma.watchme.core.domain.model.Movie
import com.yogadarma.watchme.databinding.FragmentDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movie = DetailFragmentArgs.fromBundle(arguments as Bundle).movie

        detailViewModel.getDetail(
            movie.movieId.toInt(),
            movie.category,
            movie.isNowPlaying,
            movie.isPopular,
            movie.isFavorite
        ).observe(requireActivity(), { response ->
            if (response != null) {
                when (response) {
                    is Resource.Loading -> showProgressbar()
                    is Resource.Success -> {
                        dismissProgressbar()
                        setDetail(response.data!!)
                    }
                    is Resource.Error -> {
                        dismissProgressbar()
                        Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun setDetail(movie: Movie) {
        with(binding) {
            Glide.with(binding.root)
                .load("https://image.tmdb.org/t/p/w220_and_h330_face${movie.image}").apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                ).centerCrop().into(imgDetailPoster)

            tvDetailTitle.text = movie.title
            tvDetailGenre.text = movie.genre
            tvDetailRating.text = movie.rating
            tvDetailDate.text = movie.releaseDate
            tvDetailDuration.text = "${movie.duration} minutes"
            tvDetailSynopsis.text = movie.synopsis
        }

    }

    private fun showProgressbar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun dismissProgressbar() {
        binding.progressBar.visibility = View.GONE
    }

}