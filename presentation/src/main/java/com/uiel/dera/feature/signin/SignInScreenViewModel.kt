package com.uiel.dera.feature.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignInScreenViewModel : ViewModel() {
    private val _signInState: MutableLiveData<SignInState> = MutableLiveData(SignInState())
    val signInState: LiveData<SignInState> = _signInState

    fun updateId(id: String) {
        _signInState.postValue(signInState.value?.copy(id = id))
    }

    fun updatePassword(password: String) {
        _signInState.postValue(signInState.value?.copy(password = password))
    }
}