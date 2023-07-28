package com.yumtaufikhidayat.mysimplelogin.ui

import com.yumtaufikhidayat.mysimplelogin.UserRepository
import com.yumtaufikhidayat.mysimplelogin.di.StorageModule
import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class MainActivityTest : KoinTest {

    private val userRepository by inject<UserRepository>()
    private val username = "Dicoding"

    @Before
    fun before() {
        loadKoinModules(StorageModule.storageModule)
        userRepository.loginUser(username)
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun getUserNameFromRepository() {
        val requestedUsername = userRepository.getUser()
        assertEquals(username, requestedUsername)
    }
}