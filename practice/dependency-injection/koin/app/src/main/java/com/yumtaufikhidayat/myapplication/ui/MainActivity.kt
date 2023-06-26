package com.yumtaufikhidayat.myapplication.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yumtaufikhidayat.myapplication.UserRepository
import com.yumtaufikhidayat.myapplication.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val userRepository: UserRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getUserSession()
        binding.btnLogin.setOnClickListener {
            saveSession()
        }
    }

    private fun getUserSession() {
        if (userRepository.isUserLogin()) {
            navigateToHome()
        }
    }

    private fun navigateToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    private fun saveSession() {
        userRepository.loginUser(binding.edUsername.text.toString())
        navigateToHome()
    }
}