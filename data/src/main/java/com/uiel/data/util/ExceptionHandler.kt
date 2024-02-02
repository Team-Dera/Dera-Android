package com.uiel.data.util

import com.uiel.domain.exception.BadRequestException
import com.uiel.domain.exception.ForbiddenException
import com.uiel.domain.exception.InternalServerError
import com.uiel.domain.exception.OfflineException
import com.uiel.domain.exception.TimeoutException
import com.uiel.domain.exception.TooManyRequests
import com.uiel.domain.exception.UnauthorizedException
import com.uiel.domain.exception.UnknownException
import com.uiel.domain.exception.UserAlreadyExists
import com.uiel.domain.exception.UserNotFoundException
import retrofit2.HttpException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


class ExceptionHandler<T> {

    private lateinit var httpRequest: suspend () -> T

    fun httpRequest(httpRequest: suspend () -> T) =
        this.apply { this.httpRequest = httpRequest }

    suspend fun sendRequest(): T =
        try {
            httpRequest()
        } catch (e: HttpException) {
            val code = e.code()
            throw when (code) {
                400 -> BadRequestException()
                401 -> UnauthorizedException()
                403 -> ForbiddenException()
                404 -> UserNotFoundException()
                409 -> UserAlreadyExists()
                429 -> TooManyRequests()
                500 -> InternalServerError()
                else -> UnknownException()
            }
        } catch (e: KotlinNullPointerException) {
            throw e
        } catch (e: SocketTimeoutException) {
            throw TimeoutException()
        } catch (e: UnknownHostException) {
            throw OfflineException()
        } catch (e: Throwable) {
            throw e
        }
}