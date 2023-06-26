package com.yumtaufikhidayat.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yumtaufikhidayat.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var userRepository: UserRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getUserSession()
        binding.btnLogin.setOnClickListener {
            saveSession()
        }
    }

    private fun getUserSession() {
        val session = SessionManager(this)
        userRepository = UserRepository.getInstance(session)

        if (userRepository?.isUserLogin() == true) {
            navigateToHome()
        }
    }

    private fun navigateToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    private fun saveSession() {
        userRepository?.loginUser(binding.edUsername.text.toString())
        navigateToHome()
    }
}