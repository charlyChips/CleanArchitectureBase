package com.charlychips.data.source

import com.charlychips.data.models.UserEntity
import com.charlychips.data.repository.UserCache
import com.charlychips.data.stubs.StubFactory
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserCacheDataStoreTest {

    @Mock
    private lateinit var userCache: UserCache

    private val cacheDataStore by lazy {
        UserCacheDataStore(userCache)
    }

    @Test
    fun getUsers() {
        val expectedValue = StubFactory.createUserEntityList()
        Mockito.`when`(userCache.getUsers()).thenReturn(
            Single.just(expectedValue)
        )

        cacheDataStore.getUsers()
            .test()
            .assertValue {
                it.size == expectedValue.size
            }.assertValue {
                it[0] == expectedValue[0] &&
                        it[1] == expectedValue[1]
            }
    }


    @Test
    fun getUsersEmpty() {
        val expectedValue = listOf<UserEntity>()
        Mockito.`when`(userCache.getUsers()).thenReturn(
            Single.just(expectedValue)
        )

        cacheDataStore.getUsers()
            .test()
            .assertValue {
                it.isEmpty()
            }
    }

    @Test
    fun saveUsers() {
        val users = StubFactory.createUserEntityList()

        Mockito.`when`(userCache.saveUsers(users)).thenReturn(
            Completable.complete()
        )

        cacheDataStore.saveUsers(users)
            .test()
            .assertComplete()

        Mockito.verify(userCache).setLastUpdate(anyObject())
    }

    @Test
    fun clearUsers(){

        Mockito.`when`(userCache.clearUsers()).thenReturn(
            Completable.complete()
        )

        cacheDataStore.clearUsers()

    }



    private fun <T> anyObject(): T {
        return Mockito.anyObject<T>()
    }
}