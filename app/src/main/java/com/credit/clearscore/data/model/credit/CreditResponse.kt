package com.credit.clearscore.data.model.credit

import com.google.gson.annotations.SerializedName

data class CreditResponse(
    @SerializedName("accountIDVStatus")
    val accountIDVStatus: String? = null,
    @SerializedName("dashboardStatus")
    val dashboardStatus: String? = null,
    @SerializedName("personaType")
    val personaType: String? = null,
    @SerializedName("creditReportInfo")
    val reportInfo: ReportInfo = ReportInfo()
)