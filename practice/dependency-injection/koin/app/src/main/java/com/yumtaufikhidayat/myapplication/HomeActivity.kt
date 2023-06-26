package com.yumtaufikhidayat.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yumtaufikhidayat.myapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }
    private var userRepository: UserRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initSession()
        initView()
    }

    private fun initSession() {
        val session = SessionManager(this)
        userRepository = UserRepository.getInstance(session)
    }

    private fun initView() {
        binding.apply {
            tvWelcome.text = String.format("Welcome, %s", userRepository?.getUser())
            btnLogout.setOnClickListener {
                userRepository?.logoutUser()
                moveToMainActivity()
            }
        }
    }

    private fun moveToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}