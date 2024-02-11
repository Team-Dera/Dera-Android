package com.uiel.dera.feature.signup

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.uiel.dera.feature.root.BaseViewModel
import com.uiel.dera.util.mvi.SideEffect
import com.uiel.dera.util.mvi.State
import com.uiel.domain.exception.BadRequestException
import com.uiel.domain.exception.UserAlreadyExists
import com.uiel.domain.usecase.user.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SignUpScreenViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
) : BaseViewModel<SignUpState, SignUpSideEffect>() {

    override val container = container<SignUpState, SignUpSideEffect>(SignUpState())

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

    internal fun postSignUp() = intent {
        viewModelScope.launch {
            signUpUseCase(
                userName = state.name,
                accountId = state.id,
                password = state.password,
            ).onSuccess {
                postSideEffect(SignUpSideEffect.MoveToMain)
            }.onFailure { throwable ->
                when (throwable) {
                    is BadRequestException -> {
                        reduce {
                            state.copy(
                                passwordError = true,
                                signUpBtnEnabled = false,
                            )
                        }
                    }

                    is UserAlreadyExists -> {
                        reduce {
                            state.copy(
                                idError = true,
                                signUpBtnEnabled = false,
                            )
                        }
                    }

                    else -> {
                        postSideEffect(
                            SignUpSideEffect.Exception(
                                message = getStringFormatException(
                                    throwable = throwable,
                                ),
                            ),
                        )
                    }
                }
            }
        }
    }

    private fun setSignUpBtnEnabled() = intent {
        with(state) {
            reduce {
                copy(
                    signUpBtnEnabled = id.isNotEmpty() && name.isNotEmpty()
                            && password.isNotEmpty() && !idError && passwordError
                )
            }
        }
    }
}

data class SignUpState(
    val name: String = "",
    val id: String = "",
    val password: String = "",
    val idError: Boolean = false,
    val passwordError: Boolean = false,
    val signUpBtnEnabled: Boolean = false
) : State

sealed class SignUpSideEffect : SideEffect {
    object MoveToMain : SignUpSideEffect()
    class Exception(@StringRes val message: Int) : SignUpSideEffect()
}
