package com.yumtaufikhidayat.reactivexform.domain.repository

import com.yumtaufikhidayat.reactivexform.domain.entity.MessageEntity

interface IMessageRepository {
    fun getWelcomeMessage(name: String): MessageEntity
}