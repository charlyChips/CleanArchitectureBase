package com.charlychips.presentation.base

interface BasePresenter<V> {
    var view: V?
    fun subscribe(view: V)
    fun unsubscribe()
}