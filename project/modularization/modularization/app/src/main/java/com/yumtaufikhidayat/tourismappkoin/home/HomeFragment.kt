package com.yumtaufikhidayat.tourismappkoin.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.tourismappflow.R
import com.yumtaufikhidayat.tourismappflow.databinding.FragmentHomeBinding
import com.yumtaufikhidayat.tourismappkoin.core.data.Resource
import com.yumtaufikhidayat.tourismappkoin.core.ui.TourismAdapter
import com.yumtaufikhidayat.tourismappkoin.core.utils.navigateToDetail
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModel()
    private val tourismAdapter by lazy { TourismAdapter { navigateToDetail(it) } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            setHomeAdapter()
            setData()
        }
    }

    private fun setHomeAdapter() {
        binding.rvTourism.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = tourismAdapter
        }
    }

    private fun setData() {
        homeViewModel.tourism.observe(viewLifecycleOwner) {
            binding.apply {
                if (it != null) {
                    when (it) {
                        is Resource.Loading -> showProgressBar(true)
                        is Resource.Success -> {
                            showProgressBar(false)
                            tourismAdapter.submitList(it.data)
                        }
                        is Resource.Error -> {
                            showProgressBar(false)
                            viewError.root.isVisible = true
                            viewError.tvError.text = it.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            }
        }
    }

    private fun showProgressBar(isShow: Boolean) {
        binding.progressBar.isVisible = isShow
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}