package com.yumtaufikhidayat.myapplication

class UserRepository(private val session: SessionManager) {

    fun loginUser(username: String) = session.apply {
        createLoginSession()
        saveToPreference(SessionManager.KEY_USERNAME, username)
    }

    fun getUser() = session.getFromPreference(SessionManager.KEY_USERNAME)

    fun isUserLogin() = session.isLogin

    fun logoutUser() = session.logout()

    companion object {
        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(session: SessionManager): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(session)
            }
    }
}