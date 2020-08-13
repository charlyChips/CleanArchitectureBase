package com.charlychips.data.models

data class AddressEntity(
    val street: String,
    val suite: String,
    val city: String,
    val zipCode: String,
    val geo: GeoEntity
)