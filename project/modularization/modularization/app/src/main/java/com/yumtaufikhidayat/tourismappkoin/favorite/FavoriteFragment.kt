package com.yumtaufikhidayat.tourismappkoin.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.tourismapp.core.domain.model.Tourism
import com.yumtaufikhidayat.tourismapp.core.ui.TourismAdapter
import com.yumtaufikhidayat.tourismappflow.databinding.FragmentFavoriteBinding
import com.yumtaufikhidayat.tourismappkoin.detail.DetailTourismActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private val favoriteViewModel: FavoriteViewModel by viewModel()
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

    private fun setData() {
        favoriteViewModel.favoriteTourism.observe(viewLifecycleOwner) { dataTourism ->
            tourismAdapter.submitList(dataTourism)
            binding.viewEmpty.root.visibility = if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
        }
    }

    private fun navigateToDetail(data: Tourism) {
        val intent = Intent(requireContext(), DetailTourismActivity::class.java)
        intent.putExtra(DetailTourismActivity.EXTRA_DATA, data)
        this.startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}