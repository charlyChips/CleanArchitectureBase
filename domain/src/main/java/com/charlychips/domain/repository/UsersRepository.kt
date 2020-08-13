package com.charlychips.domain.repository

import com.charlychips.domain.models.User
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface UsersRepository {

    fun getUsers(): Single<List<User>>

    fun saveUsers(users: List<User>): Completable

    fun deleteUsers(): Completable

}