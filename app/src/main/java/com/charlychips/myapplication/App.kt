package com.charlychips.myapplication

import android.app.Application
import com.charlychips.myapplication.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    mappersModule,
                    cacheModule,
                    remoteModule,
                    repositoryModule,
                    executorsModule,
                    useCaseModule,
                    presenterModule
                )
            )
        }
    }
}