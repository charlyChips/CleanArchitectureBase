package com.charlychips.data.source

import com.charlychips.data.repository.UserCache
import com.charlychips.data.repository.UserRemote
import com.charlychips.data.stubs.StubFactory
import io.reactivex.rxjava3.core.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserRemoteDataStoreTest {

    @Mock
    private lateinit var userRemote: UserRemote

    @Mock
    private lateinit var userCache: UserCache

    private val userRemoteDataStore by lazy {
        UserRemoteDataStore(
            userRemote,
            userCache
        )
    }

    @Test
    fun getRemoteUsers() {
        val expectedValue = StubFactory.createUserEntityList()
        Mockito.`when`(userCache.getUsers()).thenReturn(
            Single.just(expectedValue)
        )

        Mockito.`when`(userRemote.getUsers()).thenReturn(
            Single.just(expectedValue)
        )

        userRemoteDataStore.getUsers()
            .test()
            .assertValue {
                expectedValue.size == it.size
            }
            .assertValue {
                expectedValue[0] == it[0] &&
                        expectedValue[1] == it[1]
            }

        Mockito.verify(userCache).clearUsers()
        Mockito.verify(userCache).saveUsersDb(expectedValue)
        Mockito.verify(userCache).setLastUpdate(anyObject())

    }

    private fun <T> anyObject(): T {
        return Mockito.anyObject<T>()
    }

}