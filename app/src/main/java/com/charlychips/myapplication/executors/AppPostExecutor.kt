package com.charlychips.myapplication.executors

import com.charlychips.domain.executors.PostExecutionThread
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler

class AppPostExecutor :PostExecutionThread{
    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()

}