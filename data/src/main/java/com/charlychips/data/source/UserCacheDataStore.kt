package com.charlychips.data.source

import com.charlychips.data.models.UserEntity
import com.charlychips.data.repository.UserCache
import com.charlychips.data.repository.UserDataStore
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import java.util.*

class UserCacheDataStore(
    private val userCache: UserCache
) : UserDataStore {
    override fun getUsers(): Single<List<UserEntity>> {
        return userCache.getUsers()
    }

    override fun saveUsers(users: List<UserEntity>): Completable {
        return userCache.saveUsers(users)
            .doOnComplete { userCache.setLastUpdate(Date()) }
    }

    override fun clearUsers(): Completable {
        return userCache.clearUsers()
    }

}