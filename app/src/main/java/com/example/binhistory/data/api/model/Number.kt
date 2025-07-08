package com.example.binhistory.data.api.model

import android.health.connect.datatypes.units.Length
import com.google.gson.annotations.SerializedName

data class Number(
    @SerializedName("length") val length: Number?,
    @SerializedName("luhn") val luhn: Boolean?
)
