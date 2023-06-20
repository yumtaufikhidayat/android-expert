package com.yumtaufikhidayat.reactivexform.presentation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.jakewharton.rxbinding2.widget.RxTextView
import com.yumtaufikhidayat.reactivexform.R
import com.yumtaufikhidayat.reactivexform.databinding.ActivityMainBinding
import io.reactivex.Observable
import io.reactivex.functions.Function3

@SuppressLint("CheckResult")
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        checkValidation()
    }

    private fun checkValidation() {
        binding.apply {
            val emailStream = RxTextView.textChanges(edEmail)
                .skipInitialValue()
                .map { email ->
                    !Patterns.EMAIL_ADDRESS.matcher(email).matches()
                }
            emailStream.subscribe {
                showEmailExistAlert(it)
            }

            val passwordStream = RxTextView.textChanges(edPassword)
                .skipInitialValue()
                .map { password ->
                    password.length < 6
                }
            passwordStream.subscribe {
                showPasswordMinimalAlert(it)
            }

            val password = RxTextView.textChanges(edPassword)
                .map { password ->
                    password.toString() != edConfirmPassword.text.toString()
                }

            val confirmPassword = RxTextView.textChanges(edConfirmPassword)
                .map { confirmPassword ->
                    confirmPassword.toString() != edPassword.text.toString()
                }
            val passwordConfirmationStream = Observable.merge(password, confirmPassword)
            passwordConfirmationStream.subscribe {
                showPasswordConfirmationAlert(it)
            }

            validateButton(emailStream, passwordStream, passwordConfirmationStream)
        }
    }

    private fun validateButton(
        emailStream: Observable<Boolean>?,
        passwordStream: Observable<Boolean>?,
        passwordConfirmationStream: Observable<Boolean>?
    ) {
        val invalidFieldStream = Observable.combineLatest(
            emailStream,
            passwordStream,
            passwordConfirmationStream,
            Function3 { emailInvalid: Boolean, passwordInvalid: Boolean, confirmPasswordInvalid: Boolean ->
                !emailInvalid && !passwordInvalid && !confirmPasswordInvalid
            }
        )

        invalidFieldStream.subscribe { isValid ->
            binding.btnRegister.apply {
                if (isValid) {
                    isEnabled = true
                    setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.purple_500))
                } else {
                    isEnabled = false
                    setBackgroundColor(ContextCompat.getColor(this@MainActivity, android.R.color.darker_gray))
                }
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