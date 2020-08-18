package com.charlychips.data.source

import com.charlychips.data.repository.UserCache
import com.charlychips.data.repository.UserDataStore
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserDataStoreFactoryTest {

    @Mock
    private lateinit var userCache: UserCache


    @Mock
    private val remoteDataStore: UserDataStore = Mockito.mock(UserDataStore::class.java)

    @Mock
    private val cacheDataStore: UserDataStore = Mockito.mock(UserDataStore::class.java)

    private val factory by lazy {
        UserDataStoreFactory(
            userCache,
            cacheDataStore,
            remoteDataStore
        )
    }

    @Test
    fun getDataStoreWhenDataExpired() {
        Mockito.`when`(userCache.isExpired()).thenReturn(true)
        val actualValue = factory.getDataStore()

        Assert.assertTrue(actualValue == remoteDataStore)
    }

    @Test
    fun getDataStoreWhenDataNotExpired(){
        Mockito.`when`(userCache.isExpired()).thenReturn(false)
        val actualValue = factory.getDataStore()

        Assert.assertTrue(actualValue == cacheDataStore)
    }

}