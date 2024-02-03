package com.uiel.data.model.signup

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("username") val userName: String,
    @SerializedName("account_id") val accountId: String,
    val password: String,
)
