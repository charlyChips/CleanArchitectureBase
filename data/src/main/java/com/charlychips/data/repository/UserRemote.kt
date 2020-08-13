package com.charlychips.data.repository

import com.charlychips.data.models.UserEntity
import io.reactivex.rxjava3.core.Single

interface UserRemote {
    fun getUsers(): Single<List<UserEntity>>
}