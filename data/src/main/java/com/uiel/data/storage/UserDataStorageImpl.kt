package com.uiel.data.storage

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class UserDataStorageImpl(
    private val context: Context
) : UserDataStorage {
    override fun fetchAccessToken(): String {
        return getString(UserPersonKey.ACCESS_TOKEN)
    }

    override fun fetchRefreshToken(): String {
        return getString(UserPersonKey.REFRESH_TOKEN)
    }

    override fun fetchAccessTokenExpiresAt(): String {
        return getString(UserPersonKey.ACCESS_TOKEN_EXPIRES_AT)
    }

    override fun fetchRefreshTokenExpiresAt(): String {
        return getString(UserPersonKey.REFRESH_TOKEN_EXPIRES_AT)
    }

    override fun setUserInfo(
        accessToken: String,
        accessTokenExpiresAt: String,
        refreshToken: String,
        refreshTokenExpiresAt: String
    ) {

    }

    override fun getPreference(key: String): SharedPreferences =
        context.getSharedPreferences(key, MODE_PRIVATE)

    override fun getString(
        key: String
    ): String =
        getPreference(key).getString(key, "").toString()

    override fun putString(key: String, value: String) {
        getPreference(key).edit().putString(key, value).apply()
    }

    private object UserPersonKey {
        const val ACCESS_TOKEN = "accessToken"
        const val REFRESH_TOKEN = "refreshKey"
        const val ACCESS_TOKEN_EXPIRES_AT = "accessTokenExpiresAt"
        const val REFRESH_TOKEN_EXPIRES_AT = "refreshTokenExpiresAt"
    }
}