package com.charlychips.cache

import android.content.SharedPreferences
import com.charlychips.cache.constants.CacheConstants
import com.charlychips.cache.db.AppRoomDatabase
import com.charlychips.cache.models.UserDb
import com.charlychips.core.Transform
import com.charlychips.data.models.UserEntity
import com.charlychips.data.repository.UserCache
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import java.util.*
import java.util.concurrent.TimeUnit

class UserDataCache(
    private val db: AppRoomDatabase,
    private val sharedPreferences: SharedPreferences,
    private val userDbMapper: Transform<UserEntity, UserDb>,
    private val userEntityMapper: Transform<UserDb, UserEntity>
) : UserCache {
    override fun saveUsersDb(list: List<UserEntity>) {
        db.userDao().insertAll(userDbMapper.transform(list))
    }

    override fun saveUsers(list: List<UserEntity>): Completable {
        return Completable.create {
            saveUsersDb(list)
            it.onComplete()
        }
    }

    override fun clearUsers(): Completable {
        return Completable.create {
            db.userDao().deleteAll()
            it.onComplete()
        }
    }

    override fun getUsers(): Single<List<UserEntity>> {
        return Single.create<List<UserDb>> {
            val users = db.userDao().findAll()
            it.onSuccess(users)
        }.map {
            userEntityMapper.transform(it)
        }
    }

    override fun setLastUpdate(date: Date) {
        sharedPreferences.edit()
            .putLong(CacheConstants.SP_KEY_LAST_UPDATE, date.time)
            .apply()
    }

    override fun isExpired(): Boolean {
        val minutes = TimeUnit.MINUTES.convert(
            Date().time - getLastUpdate().time,
            TimeUnit.MILLISECONDS
        )
        return minutes > CacheConstants.TIME_EXPIRATION_MINUTES
    }

    override fun getLastUpdate(): Date {
        val time = sharedPreferences.getLong(CacheConstants.SP_KEY_LAST_UPDATE, 0L)
        return Date().apply {
            this.time = time
        }
    }

}