package com.yumtaufikhidayat.myreportapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.yumtaufikhidayat.myreportapp.databinding.ActivityMainBinding
import timber.log.Timber
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        makeCrash()
    }

    private fun makeCrash() {
        Timber.d("Test Timber Debugging")
        val crashlyticsInstance = FirebaseCrashlytics.getInstance()
        binding.btnCrash.setOnClickListener {
            crashlyticsInstance.log("Clicked on button.")
            crashlyticsInstance.setCustomKey("str_key", "some_data")
            try {
                throw RuntimeException("Test Crash")
            } catch (ex: Exception) {
                Timber.e("Test non fatal exception: $ex")
            }
        }
    }
}