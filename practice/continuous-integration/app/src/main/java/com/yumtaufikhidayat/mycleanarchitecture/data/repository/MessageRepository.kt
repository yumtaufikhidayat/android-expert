package com.yumtaufikhidayat.mycleanarchitecture.data.repository

import com.yumtaufikhidayat.mycleanarchitecture.data.source.IMessageDataSource
import com.yumtaufikhidayat.mycleanarchitecture.domain.entity.MessageEntity
import com.yumtaufikhidayat.mycleanarchitecture.domain.repository.IMessageRepository

class MessageRepository(private val messageDataSource: IMessageDataSource) : IMessageRepository {
    override fun getWelcomeMessage(name: String): MessageEntity {
        return messageDataSource.getMessageFromSource(name)
    }
}