package com.credit.clearscore.domain.usecase.credit

import com.credit.clearscore.data.model.credit.CreditResponse
import com.credit.clearscore.domain.repository.credit.CreditRepoInterface
import com.credit.clearscore.domain.repository.credit.CreditRepository
import javax.inject.Inject

class CreditUseCase @Inject constructor(private val creditRepoInterface: CreditRepoInterface) {
    suspend fun getCreditResult(): CreditResponse? =
        creditRepoInterface.getCreditResult()
}