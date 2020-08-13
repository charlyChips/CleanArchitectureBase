package com.charlychips.cache.models

import androidx.room.Embedded

data class AddressDb (
    var street: String,
    var suite: String,
    var city: String,
    var zipCode: String,
    @Embedded
    var geo: GeoDb
)