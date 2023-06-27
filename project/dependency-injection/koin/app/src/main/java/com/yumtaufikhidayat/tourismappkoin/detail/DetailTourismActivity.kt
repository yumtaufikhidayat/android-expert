package com.yumtaufikhidayat.tourismappkoin.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.yumtaufikhidayat.tourismappflow.R
import com.yumtaufikhidayat.tourismappflow.databinding.ActivityDetailTourismBinding
import com.yumtaufikhidayat.tourismappkoin.core.domain.model.Tourism
import com.yumtaufikhidayat.tourismappkoin.core.utils.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailTourismActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailTourismBinding.inflate(layoutInflater) }
    private val detailTourismViewModel: DetailTourismViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        getBundleData()
    }

    private fun getBundleData() {
        val detailTourism = intent.getParcelableExtra<Tourism>(EXTRA_DATA)
        showDetailTourism(detailTourism)
    }

    private fun showDetailTourism(detailTourism: Tourism?) {
        binding.apply {
            detailTourism?.let { tourism ->
                supportActionBar?.title = tourism.name
                content.tvDetailDescription.text = tourism.description
                ivDetailImage.loadImage(this@DetailTourismActivity, tourism.image)

                var statusFavorite = detailTourism.isFavorite
                setStatusFavorite(statusFavorite)
                fab.setOnClickListener {
                    statusFavorite = !statusFavorite
                    detailTourismViewModel?.setFavoriteTourism(tourism, statusFavorite)
                    setStatusFavorite(statusFavorite)
                }
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        val icon = if (statusFavorite) {
            ContextCompat.getDrawable(this, R.drawable.ic_favorite_white)
        } else {
            ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white)
        }

        binding.fab.setImageDrawable(icon)
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}