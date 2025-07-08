package com.example.binhistory.data.api

import com.example.binhistory.data.api.model.CardInfoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BinApiService {
    @GET("{bin}")
    suspend fun getCardInf(@Path("bin") bin: String): CardInfoResponse
}