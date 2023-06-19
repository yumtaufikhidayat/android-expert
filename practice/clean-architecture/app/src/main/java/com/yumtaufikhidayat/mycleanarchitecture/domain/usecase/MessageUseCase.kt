package com.yumtaufikhidayat.mycleanarchitecture.domain.usecase

import com.yumtaufikhidayat.mycleanarchitecture.domain.entity.MessageEntity

interface MessageUseCase {
    fun getMessage(name: String): MessageEntity
}