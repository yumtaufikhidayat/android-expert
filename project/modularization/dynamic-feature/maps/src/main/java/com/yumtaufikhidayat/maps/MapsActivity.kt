package com.yumtaufikhidayat.maps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.yumtaufikhidayat.maps.databinding.ActivityMapsBinding
import com.yumtaufikhidayat.tourismapp.core.data.Resource
import org.koin.android.ext.android.inject
import org.koin.core.context.loadKoinModules

class MapsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMapsBinding.inflate(layoutInflater) }
    private val viewModel: MapsViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadKoinModules(MapsModule.mapsModule)

        supportActionBar?.title = "Tourism Map"

        getTourismData()
    }

    private fun getTourismData() {
        binding.apply {
            viewModel.tourism.observe(this@MapsActivity) { tourism ->
                if (tourism != null) {
                    when (tourism) {
                        is Resource.Loading -> showLoading(true)
                        is Resource.Success -> {
                            showLoading(false)
                            tvMaps.text = getString(R.string.map_owner, "${tourism.data?.get(0)?.name}")
                        }
                        is Resource.Error -> {
                            showLoading(false)
                            with(tvError) {
                                isVisible = true
                                text = tourism.message
                            }
                        }
                    }
                }
            }
        }
    }

    private fun showLoading(isShow: Boolean) {
        binding.progressBar.isVisible = isShow
    }
}