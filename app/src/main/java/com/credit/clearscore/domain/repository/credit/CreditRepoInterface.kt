package com.credit.clearscore.domain.repository.credit

import com.credit.clearscore.data.model.credit.CreditResponse

interface CreditRepoInterface {

    suspend fun getCreditResult(): CreditResponse?

}