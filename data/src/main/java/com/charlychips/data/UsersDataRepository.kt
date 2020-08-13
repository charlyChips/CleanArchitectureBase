package com.charlychips.data

import com.charlychips.core.Transform
import com.charlychips.data.models.UserEntity
import com.charlychips.data.source.UserCacheDataStoreFactory
import com.charlychips.domain.models.User
import com.charlychips.domain.repository.UsersRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class UsersDataRepository(
    private val factory: UserCacheDataStoreFactory,
    private val userMapper: Transform<UserEntity, User>,
    private val userEntityMapper: Transform<User, UserEntity>
) : UsersRepository {

    override fun getUsers(): Single<List<User>> {
        return factory.getDataStore().getUsers()
            .map { userMapper.transform(it) }
    }

    override fun saveUsers(users: List<User>): Completable {
        return factory.getCacheDataStore().saveUsers(
            userEntityMapper.transform(users)
        )
    }

    override fun deleteUsers(): Completable {
        return factory.getCacheDataStore().clearUsers()
    }

}