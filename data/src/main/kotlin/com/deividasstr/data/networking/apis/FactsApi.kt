package com.deividasstr.data.networking.apis

import com.deividasstr.data.networking.models.ResponseFact
import retrofit2.http.GET
import retrofit2.http.Query

interface FactsApi {

    @GET("facts/")
    suspend fun getAllFacts(): List<ResponseFact>

    @GET("facts/")
    suspend fun getNewFacts(@Query("timestamp") afterTimestamp: Long): List<ResponseFact>
}