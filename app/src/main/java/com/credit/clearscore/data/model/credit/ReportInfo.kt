package com.credit.clearscore.data.model.credit

import com.google.gson.annotations.SerializedName

data class ReportInfo(
    @SerializedName("score")
    val score: Int = 0,
    @SerializedName("maxScoreValue")
    val maxScoreValue: Int = 0,
    @SerializedName("minScoreValue")
    val minScoreValue: Int = 0,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("clientRef")
    val clientRef: String? = null,
    @SerializedName("equifaxScoreBandDescription")
    val equifaxScoreBandDescription: String? = null,
)