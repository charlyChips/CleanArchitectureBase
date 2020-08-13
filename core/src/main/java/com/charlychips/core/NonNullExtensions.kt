package com.charlychips.core

fun String?.value(defaultValue: String = ""): String {
    return this ?: defaultValue
}

fun Int?.value(defaultValue: Int = 0): Int {
    return this ?: defaultValue
}

fun Double?.value(defaultValue: Double = 0.0): Double {
    return this ?: defaultValue
}
