package com.charlychips.myapplication.di

import com.charlychips.presentation.MainContract
import com.charlychips.presentation.MainPresenter
import org.koin.dsl.module

val presenterModule = module {
    factory<MainContract.Presenter> { MainPresenter(get()) }
}