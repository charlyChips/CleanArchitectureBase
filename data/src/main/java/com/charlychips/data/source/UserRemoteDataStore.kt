package com.charlychips.data.source

import com.charlychips.data.models.UserEntity
import com.charlychips.data.repository.UserDataStore
import com.charlychips.data.repository.UserRemote
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class UserRemoteDataStore(
    private val userRemote: UserRemote
) : UserDataStore {
    override fun getUsers(): Single<List<UserEntity>> {
        return userRemote.getUsers()
    }

    override fun saveUsers(users: List<UserEntity>): Completable {
        throw UnsupportedOperationException()
    }

    override fun clearUsers(): Completable {
        throw UnsupportedOperationException()
    }
}