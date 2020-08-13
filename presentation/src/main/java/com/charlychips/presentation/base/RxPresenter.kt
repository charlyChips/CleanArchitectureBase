package com.charlychips.presentation.base

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class RxPresenter<V> :
    BasePresenter<V> {
    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun subscribe(view: V) {
        this.view = view
    }

    override fun unsubscribe() {
        compositeDisposable.dispose()
        view = null
    }

    fun launch(job: () -> Disposable) {
        compositeDisposable.add(job())
    }
}