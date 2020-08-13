package com.charlychips.remote.models

import com.google.gson.annotations.SerializedName

data class UserBean (
    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("username")
    var username: String? = null,

    @SerializedName("email")
    var email: String? = null,

    @SerializedName("address")
    var address: AddressBean? = null,

    @SerializedName("phone")
    var phone: String? = null,

    @SerializedName("website")
    var website: String? = null,

    @SerializedName("company")
    var company: CompanyBean? = null
)