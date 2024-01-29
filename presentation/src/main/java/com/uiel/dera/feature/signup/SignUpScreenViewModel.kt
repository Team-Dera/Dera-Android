package com.uiel.dera.feature.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpScreenViewModel:ViewModel() {
    private val _signUpState: MutableLiveData<SignUpState> = MutableLiveData(SignUpState())
    val signUpState: LiveData<SignUpState> = _signUpState

    fun updateName(name: String) {
        _signUpState.postValue(signUpState.value?.copy(name = name))
    }

    fun updateId(id: String) {
        _signUpState.postValue(signUpState.value?.copy(id = id))
    }

    fun updatePassword(password: String) {
        _signUpState.postValue(signUpState.value?.copy(password = password))
    }
}

data class SignUpState(
    val name: String = "",
    val id: String = "",
    val password: String = ""
)