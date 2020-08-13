package com.charlychips.domain.models

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipCode: String,
    val geo: Geo
)