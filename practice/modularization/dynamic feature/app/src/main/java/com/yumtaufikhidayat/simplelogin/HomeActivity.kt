package com.yumtaufikhidayat.simplelogin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
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

        binding.fab.setOnClickListener {
            try {
                installChatModule()
            } catch (e: Exception) {
                showToast("Module not found!")
            }
        }
    }

    private fun installChatModule() {
        val splitInstallManager = SplitInstallManagerFactory.create(this)
        val moduleChat = "chat"
        if (splitInstallManager.installedModules.contains(moduleChat)) {
            moveToChatActivity()
            showToast("Opening module...")
        } else {
            val request = SplitInstallRequest.newBuilder()
                .addModule(moduleChat)
                .build()

            splitInstallManager.startInstall(request)
                .addOnSuccessListener {
                    showToast("Success installing module")
                    moveToChatActivity()
                }
                .addOnFailureListener {
                    showToast("Error installing module")
                }
        }
    }

    private fun moveToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun moveToChatActivity() {
        startActivity(
            Intent(
                this,
                Class.forName("com.yumtaufikhidayat.simplelogin.chat.ChatActivity")
            )
        )
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}