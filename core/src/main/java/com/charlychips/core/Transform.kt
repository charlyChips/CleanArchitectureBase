package com.charlychips.core

abstract class Transform<IN, OUT> {

    abstract fun transform(t: IN): OUT

    fun transform(list: List<IN>): List<OUT> {
        return List(list.size) {
            transform(list[it])
        }
    }
}