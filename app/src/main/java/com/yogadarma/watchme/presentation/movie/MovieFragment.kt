package com.yogadarma.watchme.presentation.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogadarma.watchme.core.data.Resource
import com.yogadarma.watchme.core.ui.NowPlayingAdapter
import com.yogadarma.watchme.core.ui.PopularAdapter
import com.yogadarma.watchme.databinding.FragmentMovieBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private val movieViewModel: MovieViewModel by viewModel()

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

        movieViewModel.getNowPlayingMovie().observe(requireActivity(), { response ->
            if (response != null) {
                when (response) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        nowPlayingAdapter.setData(response.data)
                    }
                    is Resource.Error -> {
                        Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        movieViewModel.getPopularMovie().observe(requireActivity(), { response ->
            if (response != null) {
                when (response) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        popularAdapter.setData(response.data)
                    }
                    is Resource.Error -> {
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}