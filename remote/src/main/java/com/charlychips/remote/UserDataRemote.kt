package com.charlychips.remote

import com.charlychips.core.Transform
import com.charlychips.data.models.UserEntity
import com.charlychips.data.repository.UserRemote
import com.charlychips.remote.models.UserBean
import io.reactivex.rxjava3.core.Single

class UserDataRemote(
    private val userApi: UserApi,
    private val userEntityMapper: Transform<UserBean, UserEntity>
) : UserRemote {
    override fun getUsers(): Single<List<UserEntity>> {
        return userApi.getUsers()
            .map { userEntityMapper.transform(it) }
    }
}