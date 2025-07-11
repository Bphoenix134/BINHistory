package com.example.binhistory.data.api.model

import com.google.gson.annotations.SerializedName

data class Bank(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("city") val city: String?
)
