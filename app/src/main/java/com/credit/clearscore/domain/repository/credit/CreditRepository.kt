package com.credit.clearscore.domain.repository.credit

import com.credit.clearscore.data.datasource.credit.CreditDataSource
import com.credit.clearscore.data.model.credit.CreditResponse
import javax.inject.Inject

class CreditRepository @Inject constructor(private val creditDataSource: CreditDataSource) :CreditRepoInterface{

    override suspend fun getCreditResult(): CreditResponse? {
        return creditDataSource.getCreditResult()
    }

}