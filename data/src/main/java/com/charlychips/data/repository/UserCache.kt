package com.charlychips.data.repository

import com.charlychips.data.models.UserEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import java.util.*

interface UserCache {
    fun saveUsers(list: List<UserEntity>): Completable
    fun clearUsers(): Completable
    fun getUsers(): Single<List<UserEntity>>
    fun setLastUpdate(date: Date)
    fun isExpired(): Boolean
    fun getLastUpdate(): Date
}