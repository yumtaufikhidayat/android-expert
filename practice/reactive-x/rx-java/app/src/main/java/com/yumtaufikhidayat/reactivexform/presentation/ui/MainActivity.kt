package com.yumtaufikhidayat.reactivexform.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.yumtaufikhidayat.reactivexform.databinding.ActivityMainBinding
import com.yumtaufikhidayat.reactivexform.presentation.viewmodel.MainViewModel
import com.yumtaufikhidayat.reactivexform.presentation.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setData()
    }

    private fun setData() {
        val factory = MainViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        viewModel.apply {
            setName("Dicoding")
            message.observe(this@MainActivity) {
                binding.tvWelcome.text = it.welcomeMessage
            }
        }
    }
}