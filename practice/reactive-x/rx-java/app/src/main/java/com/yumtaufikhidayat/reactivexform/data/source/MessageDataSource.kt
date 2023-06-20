package com.yumtaufikhidayat.reactivexform.data.source

import com.yumtaufikhidayat.reactivexform.data.source.IMessageDataSource
import com.yumtaufikhidayat.reactivexform.domain.entity.MessageEntity

class MessageDataSource: IMessageDataSource {
    override fun getMessageFromSource(name: String): MessageEntity {
        return MessageEntity("Hello $name! Welcome to Clean Architecture")
    }
}