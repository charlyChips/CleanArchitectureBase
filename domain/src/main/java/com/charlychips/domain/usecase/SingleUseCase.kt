package com.charlychips.domain.usecase

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single

abstract class SingleUseCase<T, in PARAMS> protected constructor(
    private val jobExecutor: Scheduler,
    private val postExecutor: Scheduler
) {
    abstract fun build(params: PARAMS? = null): Single<T>

    fun execute(params: PARAMS? = null): Single<T> {
        return build(params)
            .subscribeOn(jobExecutor)
            .observeOn(postExecutor)
    }
}