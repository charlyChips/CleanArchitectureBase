package com.charlychips.domain.usecase

import com.charlychips.domain.executors.JobExecutionThread
import com.charlychips.domain.executors.PostExecutionThread
import io.reactivex.rxjava3.core.Single

abstract class SingleUseCase<T, in PARAMS> protected constructor(
    private val jobExecutor: JobExecutionThread,
    private val postExecutor: PostExecutionThread
) {
    abstract fun build(params: PARAMS? = null): Single<T>

    fun execute(params: PARAMS? = null): Single<T> {
        return build(params)
            .subscribeOn(jobExecutor.scheduler)
            .observeOn(postExecutor.scheduler)
    }
}