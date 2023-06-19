package com.yumtaufikhidayat.mycleanarchitecture.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.mycleanarchitecture.domain.entity.MessageEntity
import com.yumtaufikhidayat.mycleanarchitecture.domain.usecase.MessageUseCase

class MainViewModel(private val messageUseCase: MessageUseCase) : ViewModel() {
    private val _message = MutableLiveData<MessageEntity>()
    val message: LiveData<MessageEntity>
        get() = _message

    fun setName(name: String) {
        _message.value = messageUseCase.getMessage(name)
    }
}