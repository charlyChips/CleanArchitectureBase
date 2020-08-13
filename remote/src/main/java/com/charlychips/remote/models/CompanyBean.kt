package com.charlychips.remote.models

import com.google.gson.annotations.SerializedName

data class CompanyBean(
    @SerializedName("name")
    var name: String,

    @SerializedName("catchPhrase")
    var slogan: String,

    @SerializedName("bs")
    var business: String
)