package com.charlychips.myapplication.di

import com.charlychips.domain.executors.JobExecutionThread
import com.charlychips.domain.executors.PostExecutionThread
import com.charlychips.domain.usecase.GetUsersUseCase
import com.charlychips.myapplication.executors.AppJobExecutor
import com.charlychips.myapplication.executors.AppPostExecutor
import org.koin.dsl.module

val executorsModule = module {
    factory<JobExecutionThread> { AppJobExecutor() }
    factory<PostExecutionThread> { AppPostExecutor() }
}

val useCaseModule = module {
    factory {
        GetUsersUseCase(get(), get(), get())
    }
}