package com.yogadarma.watchme.presentation.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.watchme.adapter.NowPlayingAdapter
import com.yogadarma.watchme.adapter.PopularAdapter
import com.yogadarma.watchme.databinding.FragmentMovieBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private val movieViewModel: MovieViewModel by viewModel()

    private var isSuccess = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finishAfterTransition()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nowPlayingAdapter = NowPlayingAdapter()
        val popularAdapter = PopularAdapter()

        nowPlayingAdapter.onItemClick = { movie ->
            navigateToDetail(movie)
        }

        popularAdapter.onItemClick = { movie ->
            navigateToDetail(movie)
        }

        movieViewModel.getNowPlayingMovie().observe(viewLifecycleOwner, { response ->
            if (response != null) {
                when (response) {
                    is Resource.Loading -> {
                        loadingVisibility()
                    }
                    is Resource.Success -> {
                        if (isSuccess) {
                            binding.shimmerNowPlaying.visibility = View.GONE
                            successVisibility()
                            nowPlayingAdapter.setData(response.data)
                        } else {
                            errorVisibility()
                        }
                    }
                    is Resource.Error -> {
                        isSuccess = false
                        errorVisibility()
                        Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        movieViewModel.getPopularMovie().observe(viewLifecycleOwner, { response ->
            if (response != null) {
                when (response) {
                    is Resource.Loading -> {
                        loadingVisibility()
                    }
                    is Resource.Success -> {
                        if (isSuccess) {
                            binding.shimmerPopular.visibility = View.GONE
                            successVisibility()
                            popularAdapter.setData(response.data)
                        } else {
                            errorVisibility()
                        }
                    }
                    is Resource.Error -> {
                        isSuccess = false
                        errorVisibility()
                        Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        with(binding.rvNowPlayingMovie) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = nowPlayingAdapter
        }

        with(binding.rvPopularMovie) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = popularAdapter
        }
    }

    private fun loadingVisibility() {
        binding.shimmerNowPlaying.visibility = View.VISIBLE
        binding.shimmerPopular.visibility = View.VISIBLE
        binding.viewError.root.visibility = View.GONE
    }

    private fun successVisibility() {
        binding.viewError.root.visibility = View.GONE
    }

    private fun errorVisibility() {
        binding.labelNowPlayingMovie.visibility = View.GONE
        binding.labelPopularMovie.visibility = View.GONE
        binding.shimmerNowPlaying.visibility = View.GONE
        binding.shimmerPopular.visibility = View.GONE
        binding.rvNowPlayingMovie.visibility = View.GONE
        binding.rvPopularMovie.visibility = View.GONE
        binding.viewError.root.visibility = View.VISIBLE
    }

    private fun navigateToDetail(movie: Movie) {
        val navigate = MovieFragmentDirections.actionMovieFragmentToDetailFragment(movie)
        findNavController().navigate(navigate)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}