package com.credit.clearscore.data.datasource.credit

import com.credit.clearscore.api.CreditApi
import com.credit.clearscore.base.BaseRepository
import com.credit.clearscore.data.model.credit.CreditResponse
import javax.inject.Inject

class CreditDataSource @Inject constructor(
    private val creditApi: CreditApi,
    private val baseRepository: BaseRepository
) {

    suspend fun getCreditResult(): CreditResponse? =
        baseRepository.request(call = { creditApi.getCreditResult() })

}