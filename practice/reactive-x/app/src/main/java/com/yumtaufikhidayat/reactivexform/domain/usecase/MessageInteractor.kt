package com.yumtaufikhidayat.reactivexform.domain.usecase

import com.yumtaufikhidayat.reactivexform.domain.entity.MessageEntity
import com.yumtaufikhidayat.reactivexform.domain.repository.IMessageRepository

class MessageInteractor(private val messageRepository: IMessageRepository): MessageUseCase {
    override fun getMessage(name: String): MessageEntity {
        return messageRepository.getWelcomeMessage(name)
    }
}