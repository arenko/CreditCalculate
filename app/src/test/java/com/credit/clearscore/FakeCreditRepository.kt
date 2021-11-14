package com.credit.clearscore

import com.credit.clearscore.data.model.credit.CreditResponse
import com.credit.clearscore.domain.repository.credit.CreditRepoInterface

class FakeCreditRepository : CreditRepoInterface {
    private var credit = CreditResponse()

    init {
        credit = CreditResponse("PASS")
    }


    override suspend fun getCreditResult(): CreditResponse {
        return credit
    }

}