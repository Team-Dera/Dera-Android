package com.uiel.dera.feature.root

import androidx.lifecycle.ViewModel
import com.uiel.dera.R
import com.uiel.dera.util.mvi.SideEffect
import com.uiel.dera.util.mvi.State
import com.uiel.domain.exception.BadRequestException
import com.uiel.domain.exception.ForbiddenException
import com.uiel.domain.exception.InternalServerError
import com.uiel.domain.exception.OfflineException
import com.uiel.domain.exception.TimeoutException
import com.uiel.domain.exception.TooManyRequests
import com.uiel.domain.exception.UnauthorizedException
import com.uiel.domain.exception.UserAlreadyExists
import com.uiel.domain.exception.UserNotFoundException
import org.orbitmvi.orbit.ContainerHost

abstract class BaseViewModel<S : State, E : SideEffect> : ContainerHost<S, E>, ViewModel() {
    protected fun getStringFormatException(throwable: Throwable) = when (throwable) {
        is BadRequestException -> R.string.bad_request_exception
        is UnauthorizedException -> R.string.unauthorized_exception
        is ForbiddenException -> R.string.forbidden_exception
        is UserNotFoundException -> R.string.user_not_found_exception
        is UserAlreadyExists -> R.string.user_already_exists
        is TooManyRequests -> R.string.too_many_requests
        is InternalServerError -> R.string.internal_server_error
        is TimeoutException -> R.string.timeout_exception
        is OfflineException -> R.string.offline_exception
        else -> R.string.unknown_error
    }
}
