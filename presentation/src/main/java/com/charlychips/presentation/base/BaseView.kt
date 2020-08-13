package com.charlychips.presentation.base

interface BaseView<T : BasePresenter<*>> {
    val presenter: T
    fun showError(message: String)
}