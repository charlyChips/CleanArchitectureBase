package com.charlychips.presentation

import com.charlychips.domain.models.User
import com.charlychips.presentation.base.BasePresenter
import com.charlychips.presentation.base.BaseView

interface MainContract {
    interface View:BaseView<Presenter>{
        fun showUsers(list:List<User>)
    }
    interface Presenter:BasePresenter<View>{
        fun getUsers()
    }
}