package com.charlychips.domain.executors

import io.reactivex.rxjava3.core.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}