package com.yumtaufikhidayat.myapplication

import android.content.Context

class SessionManager(context: Context) {

    private var pref = context.getSharedPreferences(SESSION_NAME, Context.MODE_PRIVATE)
    private var editor = pref.edit()

    val isLogin = pref.getBoolean(KEY_LOGIN, false)

    fun createLoginSession() = editor.putBoolean(KEY_LOGIN, true).commit()

    fun logout() = editor.apply {
        clear()
        commit()
    }

    fun saveToPreference(key: String, value: String) = editor.putString(key, value).commit()

    fun getFromPreference(key: String) = pref.getString(key, "")

    companion object {
        const val KEY_LOGIN = "isLogin"
        const val KEY_USERNAME = "username"
        const val SESSION_NAME = "Session"
    }
}