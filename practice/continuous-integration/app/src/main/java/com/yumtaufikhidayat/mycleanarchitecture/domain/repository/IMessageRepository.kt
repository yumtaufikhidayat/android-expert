package com.yumtaufikhidayat.mycleanarchitecture.domain.repository

import com.yumtaufikhidayat.mycleanarchitecture.domain.entity.MessageEntity

interface IMessageRepository {
    fun getWelcomeMessage(name: String): MessageEntity
}