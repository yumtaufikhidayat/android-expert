package com.yumtaufikhidayat.tourismappflow.favorite

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.tourismappflow.MyApplication
import com.yumtaufikhidayat.tourismappflow.core.ui.TourismAdapter
import com.yumtaufikhidayat.tourismappflow.core.ui.ViewModelFactory
import com.yumtaufikhidayat.tourismappflow.core.utils.navigateToDetail
import com.yumtaufikhidayat.tourismappflow.databinding.FragmentFavoriteBinding
import javax.inject.Inject

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private val tourismAdapter by lazy { TourismAdapter { navigateToDetail(it) } }

    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}