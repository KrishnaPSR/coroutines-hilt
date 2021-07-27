package com.deividasstr.data.networking.apis

import com.deividasstr.data.networking.models.ResponseSweet
import retrofit2.http.GET
import retrofit2.http.Query

interface SweetsApi {

    @GET("sweets/")
    suspend fun getAllSweets(): List<ResponseSweet>

    @GET("sweets/")
    suspend fun getNewSweets(@Query("timestamp") afterTimestamp: Long): List<ResponseSweet>
}