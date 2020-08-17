package com.charlychips.domain.executors

import io.reactivex.rxjava3.core.Scheduler

interface JobExecutionThread {
    val scheduler: Scheduler
}