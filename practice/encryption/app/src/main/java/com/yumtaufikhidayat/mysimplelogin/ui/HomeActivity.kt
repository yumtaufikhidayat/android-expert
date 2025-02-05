package com.yumtaufikhidayat.mysimplelogin.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yumtaufikhidayat.MyApplication
import com.yumtaufikhidayat.myapplication.databinding.ActivityHomeBinding
import com.yumtaufikhidayat.mysimplelogin.UserRepository
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.apply {
            tvWelcome.text = String.format("Welcome, %s", userRepository.getUser())
            btnLogout.setOnClickListener {
                userRepository.logoutUser()
                moveToMainActivity()
            }
        }
    }

    private fun moveToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}