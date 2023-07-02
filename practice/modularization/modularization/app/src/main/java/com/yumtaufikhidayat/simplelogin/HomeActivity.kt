package com.yumtaufikhidayat.simplelogin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yumtaufikhidayat.core.UserRepository
import com.yumtaufikhidayat.simplelogin.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }
    private var userRepository: UserRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val session = com.yumtaufikhidayat.core.SessionManager(this)
        userRepository = UserRepository.getInstance(session)

        binding.tvWelcome.text = String.format("%s %s", "Welcome", "${userRepository?.getUser()}")

        binding.btnLogout.setOnClickListener {
            userRepository?.logoutUser()
            moveToMainActivity()
        }
    }

    private fun moveToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}