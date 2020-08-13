package com.charlychips.remote

import com.charlychips.remote.constants.UserConstants
import com.charlychips.remote.models.UserBean
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface UserApi {
    @GET(UserConstants.GET_USERS_API)
    fun getUsers(): Single<List<UserBean>>
}