package com.charlychips.data.source

import com.charlychips.data.models.UserEntity
import com.charlychips.data.repository.UserCache
import com.charlychips.data.repository.UserDataStore
import com.charlychips.data.repository.UserRemote
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import java.util.*

class UserRemoteDataStore(
    private val userRemote: UserRemote,
    private val userCache: UserCache
) : UserDataStore {
    override fun getUsers(): Single<List<UserEntity>> {
        return userRemote.getUsers()
            .flatMap {
                userCache.clearUsers()
                userCache.saveUsersDb(it)
                userCache.setLastUpdate(Date())
                userCache.getUsers()
            }
    }

    override fun saveUsers(users: List<UserEntity>): Completable {
        throw UnsupportedOperationException()
    }

    override fun clearUsers(): Completable {
        throw UnsupportedOperationException()
    }
}