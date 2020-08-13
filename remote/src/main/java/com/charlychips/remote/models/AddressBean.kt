package com.charlychips.remote.models

import com.google.gson.annotations.SerializedName

data class AddressBean (
    @SerializedName("street")
    var street: String? = null,

    @SerializedName("suite")
    val suite: String? = null,

    @SerializedName("city")
    val city: String? = null,

    @SerializedName("zipcode")
    val zipCode: String? = null,

    @SerializedName("geo")
    val geo: GeoBean? = null
)