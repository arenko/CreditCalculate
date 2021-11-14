package com.credit.clearscore.api

import com.credit.clearscore.data.model.credit.CreditResponse
import retrofit2.Response
import retrofit2.http.GET

interface CreditApi {
    @GET("endpoint.json")
    suspend fun getCreditResult(): Response<CreditResponse>
}