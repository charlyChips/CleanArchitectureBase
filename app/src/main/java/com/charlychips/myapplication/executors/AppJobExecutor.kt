package com.charlychips.myapplication.executors

import com.charlychips.domain.executors.JobExecutionThread
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class AppJobExecutor : JobExecutionThread {
    override val scheduler: Scheduler
        get() = Schedulers.io()


}