package com.charlychips.data.repository

import com.charlychips.data.models.UserEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface UserDataStore {
    fun getUsers(): Single<List<UserEntity>>
    fun saveUsers(users: List<UserEntity>): Completable
    fun clearUsers(): Completable
}