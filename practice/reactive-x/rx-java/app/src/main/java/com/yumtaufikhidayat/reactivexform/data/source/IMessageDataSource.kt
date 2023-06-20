package com.yumtaufikhidayat.reactivexform.data.source

import com.yumtaufikhidayat.reactivexform.domain.entity.MessageEntity

interface IMessageDataSource {
    fun getMessageFromSource(name: String): MessageEntity
}