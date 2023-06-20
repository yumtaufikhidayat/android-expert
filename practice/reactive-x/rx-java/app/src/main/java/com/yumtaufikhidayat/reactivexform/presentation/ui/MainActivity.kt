package com.yumtaufikhidayat.reactivexform.presentation.ui

import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.yumtaufikhidayat.reactivexform.R
import com.yumtaufikhidayat.reactivexform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var emailValid = false
    private var passwordValid = false
    private var passwordConfirmationValid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        validateButton()
        checkValidation()
    }

    private fun checkValidation() {
        binding.apply {
            edEmail.addTextChangedListener(onTextChanged = { _, _, _, _ ->
                validateEmail()
            })

            edPassword.addTextChangedListener(onTextChanged = { _, _, _, _ ->
                validatePassword()
            })

            edConfirmPassword.addTextChangedListener(onTextChanged = { _, _, _, _ ->
                validatePasswordConfirmation()
            })
        }
    }

    private fun validateEmail() {
        // jika password tidak valid tampilkan peringatan
        val input = binding.edEmail.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(input).matches()) {
            emailValid = false
            showEmailExistAlert(true)
        } else {
            emailValid = true
            showEmailExistAlert(false)
        }
        validateButton()
    }

    private fun validatePassword() {
        // jika password < 6 karakter tampilkan peringatan
        val input = binding.edPassword.text.toString()
        if (input.length < 6) {
            passwordValid = false
            showPasswordMinimalAlert(true)
        } else {
            passwordValid = true
            showPasswordMinimalAlert(false)
        }
        validateButton()
    }

    private fun validatePasswordConfirmation() {
        // jika konfirmasi password tidak sesuai tampilkan peringatan
        binding.apply {
            val input = edConfirmPassword.text.toString()
            if (input != edPassword.text.toString()) {
                passwordConfirmationValid = false
                showPasswordConfirmationAlert(true)
            } else {
                passwordConfirmationValid = true
                showPasswordConfirmationAlert(false)
            }
            validateButton()
        }
    }

    private fun validateButton() {
        // jika semua field sudah terisi, enable button submit
        binding.btnRegister.apply {
            if (emailValid && passwordValid && passwordConfirmationValid) {
                isEnabled = true
                setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.purple_500))
            } else {
                isEnabled = false
                setBackgroundColor(ContextCompat.getColor(this@MainActivity, android.R.color.darker_gray))
            }
        }
    }

    private fun showEmailExistAlert(isNotValid: Boolean) {
        binding.edEmail.error = if (isNotValid) getString(R.string.email_not_valid) else null
    }

    private fun showPasswordMinimalAlert(isNotValid: Boolean) {
        binding.edPassword.error = if (isNotValid) getString(R.string.password_not_valid) else null
    }

    private fun showPasswordConfirmationAlert(isNotValid: Boolean) {
        binding.edConfirmPassword.error = if (isNotValid) getString(R.string.password_not_same) else null
    }
}