package com.yumtaufikhidayat.reactivexform.presentation.di

import com.yumtaufikhidayat.reactivexform.data.repository.MessageRepository
import com.yumtaufikhidayat.reactivexform.data.source.IMessageDataSource
import com.yumtaufikhidayat.reactivexform.data.source.MessageDataSource
import com.yumtaufikhidayat.reactivexform.domain.repository.IMessageRepository
import com.yumtaufikhidayat.reactivexform.domain.usecase.MessageInteractor
import com.yumtaufikhidayat.reactivexform.domain.usecase.MessageUseCase

object Injection {
    fun provideUseCase(): MessageUseCase {
        val messageRepository = provideRepository()
        return MessageInteractor(messageRepository)
    }

    private fun provideRepository(): IMessageRepository {
        val messageDataSource = provideDataSource()
        return MessageRepository(messageDataSource)
    }

    private fun provideDataSource(): IMessageDataSource {
        return MessageDataSource()
    }
}