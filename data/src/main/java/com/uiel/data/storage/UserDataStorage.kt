package com.uiel.data.storage

import android.content.SharedPreferences

interface UserDataStorage {

    fun fetchAccessToken(): String
    fun fetchRefreshToken(): String
    fun fetchAccessTokenExpiresAt(): String
    fun fetchRefreshTokenExpiresAt(): String

    fun setUserInfo(
        accessToken: String,
        accessTokenExpiresAt: String,
        refreshToken: String,
        refreshTokenExpiresAt: String,
    )

    fun getPreference(key: String): SharedPreferences

    fun getString(key: String): String

    fun putString(
        key: String,
        value: String,
    )
}