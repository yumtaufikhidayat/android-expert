package com.yumtaufikhidayat.mycleanarchitecture.presentation.di

import com.yumtaufikhidayat.mycleanarchitecture.data.repository.MessageRepository
import com.yumtaufikhidayat.mycleanarchitecture.data.source.IMessageDataSource
import com.yumtaufikhidayat.mycleanarchitecture.data.source.MessageDataSource
import com.yumtaufikhidayat.mycleanarchitecture.domain.repository.IMessageRepository
import com.yumtaufikhidayat.mycleanarchitecture.domain.usecase.MessageInteractor
import com.yumtaufikhidayat.mycleanarchitecture.domain.usecase.MessageUseCase

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