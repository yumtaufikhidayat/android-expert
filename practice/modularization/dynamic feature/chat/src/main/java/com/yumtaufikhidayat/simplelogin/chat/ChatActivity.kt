package com.yumtaufikhidayat.simplelogin.chat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yumtaufikhidayat.core.SessionManager
import com.yumtaufikhidayat.core.UserRepository
import com.yumtaufikhidayat.simplelogin.chat.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    private val binding by lazy { ActivityChatBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getSessionName()
    }

    private fun getSessionName() {
        val session = SessionManager(this)
        val userRepository = UserRepository(session)
        binding.tvChat.text = getString(R.string.hello, "${userRepository.getUser()}")
    }
}