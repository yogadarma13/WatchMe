package com.yogadarma.watchme.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.utils.DateFormat
import com.yogadarma.watchme.R
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
        ).observe(viewLifecycleOwner, { response ->
            if (response != null) {
                when (response) {
                    is Resource.Loading -> loadingVisibility()
                    is Resource.Success -> {
                        successVisibility()
                        setDetail(response.data!!)
                    }
                    is Resource.Error -> {
                        errorVisibility()
                        Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnShare.setOnClickListener {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder.from(requireActivity()).apply {
                setType(mimeType)
                setChooserTitle(getString(R.string.share_title))
                setText(resources.getString(R.string.share_text, movie.title))
                startChooser()
            }
        }
    }

    private fun setDetail(movie: Movie) {
        Glide.with(binding.root)
            .load("https://image.tmdb.org/t/p/w220_and_h330_face${movie.image}").apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading_image)
                    .error(R.drawable.ic_error_image)
            ).centerCrop().into(binding.imgDetailPoster)

        binding.tvDetailTitle.text = movie.title
        binding.tvDetailGenre.text = movie.genre
        binding.tvDetailRating.text = movie.rating
        binding.tvDetailDate.text =
            if (movie.releaseDate.isEmpty()) "-" else DateFormat.format(movie.releaseDate)
        binding.tvDetailDuration.text = resources.getString(R.string.duration, movie.duration)
        binding.tvDetailSynopsis.text = movie.synopsis

        var favoriteStatus = movie.isFavorite
        setFavoriteStatus(favoriteStatus)
        binding.btnFavorite.setOnClickListener {
            favoriteStatus = !favoriteStatus
            detailViewModel.setFavoriteMovie(movie, favoriteStatus)
            setFavoriteStatus(favoriteStatus)
        }
    }

    private fun setFavoriteStatus(favoriteStatus: Boolean) {
        if (favoriteStatus) {
            binding.btnFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    binding.root.context,
                    R.drawable.ic_favorite_red
                )
            )
        } else {
            binding.btnFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    binding.root.context,
                    R.drawable.ic_favorite_border
                )
            )
        }
    }


    private fun loadingVisibility() {
        binding.progressBar.visibility = View.VISIBLE
        binding.viewError.root.visibility = View.GONE
    }

    private fun successVisibility() {
        binding.progressBar.visibility = View.GONE
        binding.viewError.root.visibility = View.GONE
    }

    private fun errorVisibility() {
        binding.containerDetail.visibility = View.GONE
        binding.btnShare.visibility = View.GONE
        binding.btnBack.visibility = View.GONE
        binding.btnFavorite.visibility = View.GONE
        binding.progressBar.visibility = View.GONE
        binding.viewError.root.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}