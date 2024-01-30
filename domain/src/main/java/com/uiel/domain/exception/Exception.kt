package com.uiel.domain.exception

class BadRequestException() : Throwable() //400
class UnauthorizedException() : Throwable() //401
class ForbiddenException() : Throwable() //403
class UserNotFoundException() : Throwable() //404
class UserAlreadyExists() : Throwable() //409
class TooManyRequests() : Throwable() //429
class InternalServerError() : Throwable() //500
class TimeoutException() : Throwable() // Timeout
class OfflineException() : Throwable() // Offline
class UnknownException() : Throwable() // UnknownException
