package com.yumtaufikhidayat.myapplication.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yumtaufikhidayat.MyApplication
import com.yumtaufikhidayat.myapplication.UserRepository
import com.yumtaufikhidayat.myapplication.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var userRepository2: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        userRepository.checkInstance()
        userRepository2.checkInstance()

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