package com.charlychips.domain.usecase

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler

abstract class CompletableUseCase<in PARAMS> protected constructor(
    private val jobExecutor: Scheduler,
    private val postExecutor: Scheduler
) {

    abstract fun build(params: PARAMS? = null): Completable

    fun execute(params: PARAMS? = null): Completable {
        return build(params)
            .subscribeOn(jobExecutor)
            .observeOn(postExecutor)
    }



}