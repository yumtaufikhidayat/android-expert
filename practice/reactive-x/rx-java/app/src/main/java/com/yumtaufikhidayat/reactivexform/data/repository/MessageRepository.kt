package com.yumtaufikhidayat.reactivexform.data.repository

import com.yumtaufikhidayat.reactivexform.data.source.IMessageDataSource
import com.yumtaufikhidayat.reactivexform.domain.entity.MessageEntity
import com.yumtaufikhidayat.reactivexform.domain.repository.IMessageRepository

class MessageRepository(private val messageDataSource: IMessageDataSource) : IMessageRepository {
    override fun getWelcomeMessage(name: String): MessageEntity {
        return messageDataSource.getMessageFromSource(name)
    }
}