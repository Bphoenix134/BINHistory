package com.example.binhistory.data.api.model

import com.google.gson.annotations.SerializedName

data class CardInfoResponse(
    @SerializedName("number") val number:  Number?,
    @SerializedName("scheme") val scheme:  String?,
    @SerializedName("type") val type:  String?,
    @SerializedName("brand") val brand:  String?,
    @SerializedName("prepaid") val prepaid:  Boolean?,
    @SerializedName("country") val country:  String?,
    @SerializedName("bank") val bank:  String?
)
