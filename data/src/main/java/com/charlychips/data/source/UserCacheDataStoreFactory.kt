package com.charlychips.data.source

import com.charlychips.data.repository.UserCache
import com.charlychips.data.repository.UserDataStore

class UserCacheDataStoreFactory(
    private val userCache:UserCache,
    private val userCacheDataStore: UserCacheDataStore,
    private val userRemoteDataStore: UserRemoteDataStore
) {

    fun getDataStore():UserDataStore{
        return if(userCache.isExpired()){
            getRemoteDataStore()
        }else{
            getCacheDataStore()
        }
    }

    fun getCacheDataStore():UserDataStore{
        return userCacheDataStore
    }

    fun getRemoteDataStore():UserDataStore{
        return userRemoteDataStore
    }

}