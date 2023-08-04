package com.yumtaufikhidayat.myreportapp.utils

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

class ReleaseTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        val crashlyticsInstance = FirebaseCrashlytics.getInstance()
        if (priority == Log.ERROR || priority == Log.WARN) {
            if (t == null) {
                crashlyticsInstance.log(message)
            } else {
                crashlyticsInstance.recordException(t)
            }
        }
    }
}