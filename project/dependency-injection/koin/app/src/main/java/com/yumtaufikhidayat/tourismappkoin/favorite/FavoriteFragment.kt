package com.yumtaufikhidayat.tourismappkoin.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.tourismappflow.databinding.FragmentFavoriteBinding
import com.yumtaufikhidayat.tourismappkoin.core.ui.TourismAdapter
import com.yumtaufikhidayat.tourismappkoin.core.ui.ViewModelFactory
import com.yumtaufikhidayat.tourismappkoin.core.utils.navigateToDetail

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private var favoriteViewModel: FavoriteViewModel? = null
    private val tourismAdapter by lazy { TourismAdapter { navigateToDetail(it) } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            setTourismAdapter()
            setViewModel()
            setData()
        }
    }

    private fun setTourismAdapter() {
        binding.rvTourism.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = tourismAdapter
        }
    }

    private fun setViewModel() {
        val factory = ViewModelFactory.getInstance(requireActivity())
        favoriteViewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]
    }

    private fun setData() {
        favoriteViewModel?.favoriteTourism?.observe(viewLifecycleOwner) { dataTourism ->
            tourismAdapter.submitList(dataTourism)
            binding.viewEmpty.root.visibility = if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}