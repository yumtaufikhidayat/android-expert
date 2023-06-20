package com.yumtaufikhidayat.reactivexform.domain.usecase

import com.yumtaufikhidayat.reactivexform.domain.entity.MessageEntity

interface MessageUseCase {
    fun getMessage(name: String): MessageEntity
}