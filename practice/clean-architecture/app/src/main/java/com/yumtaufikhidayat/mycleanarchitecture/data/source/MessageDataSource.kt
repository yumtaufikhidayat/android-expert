package com.yumtaufikhidayat.mycleanarchitecture.data.source

import com.yumtaufikhidayat.mycleanarchitecture.domain.entity.MessageEntity

class MessageDataSource: IMessageDataSource {
    override fun getMessageFromSource(name: String): MessageEntity {
        return MessageEntity("Hello $name! Welcome to Clean Architecture")
    }
}