package com.yumtaufikhidayat.reactivexsearch.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.yumtaufikhidayat.reactivexsearch.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        searchPlace()
    }

    private fun searchPlace() {
        binding.apply {
            edPlace.addTextChangedListener(onTextChanged = { s, _, _, _ ->
                lifecycleScope.launch {
                    viewModel.apply {
                        queryChannel.value = s.toString()
                        searchResult.observe(this@MainActivity) {
                            val placesName = it.map { place -> place.placeName }
                            val adapter = ArrayAdapter(this@MainActivity, android.R.layout.select_dialog_item, placesName)
                            adapter.notifyDataSetChanged()
                            edPlace.setAdapter(adapter)
                        }
                    }
                }
            })
        }
    }
}