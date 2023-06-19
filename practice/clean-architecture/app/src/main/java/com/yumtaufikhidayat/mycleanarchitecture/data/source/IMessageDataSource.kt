package com.yumtaufikhidayat.mycleanarchitecture.data.source

import com.yumtaufikhidayat.mycleanarchitecture.domain.entity.MessageEntity

interface IMessageDataSource {
    fun getMessageFromSource(name: String): MessageEntity
}