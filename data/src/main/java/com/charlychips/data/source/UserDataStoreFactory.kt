package com.charlychips.data.source

import com.charlychips.data.repository.UserCache
import com.charlychips.data.repository.UserDataStore

class UserDataStoreFactory(
    private val userCache:UserCache,
    private val userCacheDataStore: UserDataStore,
    private val userRemoteDataStore: UserDataStore
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