package com.charlychips.presentation

import com.charlychips.domain.usecase.GetUsersUseCase
import com.charlychips.presentation.base.RxPresenter

class MainPresenter(
    private val getUsersUseCase: GetUsersUseCase
) : RxPresenter<MainContract.View>(), MainContract.Presenter {

    override var view: MainContract.View? = null

    override fun getUsers() {
        launch {
            getUsersUseCase.execute()
                .subscribe({
                    view?.showUsers(it)
                }, {
                    it?.message?.let { msg ->
                        view?.showError(msg)
                    }
                })
        }
    }
}