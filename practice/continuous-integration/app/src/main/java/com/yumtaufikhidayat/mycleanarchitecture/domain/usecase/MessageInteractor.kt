package com.yumtaufikhidayat.mycleanarchitecture.domain.usecase

import com.yumtaufikhidayat.mycleanarchitecture.domain.entity.MessageEntity
import com.yumtaufikhidayat.mycleanarchitecture.domain.repository.IMessageRepository

class MessageInteractor(private val messageRepository: IMessageRepository): MessageUseCase {
    override fun getMessage(name: String): MessageEntity {
        return messageRepository.getWelcomeMessage(name)
    }
}