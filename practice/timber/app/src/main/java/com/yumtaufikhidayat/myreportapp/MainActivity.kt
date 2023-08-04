package com.yumtaufikhidayat.myreportapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.yumtaufikhidayat.myreportapp.databinding.ActivityMainBinding
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        makeCrash()
    }

    private fun makeCrash() {
        val crashlyticsInstance = FirebaseCrashlytics.getInstance()
        binding.btnCrash.setOnClickListener {
            crashlyticsInstance.log("Clicked on button.")
            crashlyticsInstance.setCustomKey("str_key", "some_data")
            throw RuntimeException("Test Crash")
        }
    }
}