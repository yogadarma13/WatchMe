package com.yogadarma.watchme.presentation.tvshow

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
import com.yogadarma.watchme.databinding.FragmentTvShowBinding
import org.koin.android.viewmodel.ext.android.viewModel

class TvShowFragment : Fragment() {

    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding!!
    private val tvShowViewModel: TvShowViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nowPlayingAdapter = NowPlayingAdapter()
        val popularAdapter = PopularAdapter()

        tvShowViewModel.getAllNowPlayingTVShow().observe(requireActivity(), { response ->
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

        tvShowViewModel.getAllPopularTVShow().observe(requireActivity(), { response ->
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

        with(binding.rvNowPlayingTvShow) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = nowPlayingAdapter
        }

        with(binding.rvPopularTvShow) {
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