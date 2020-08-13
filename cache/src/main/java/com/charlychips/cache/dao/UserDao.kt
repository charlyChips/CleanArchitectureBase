package com.charlychips.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.charlychips.cache.models.UserDb
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface UserDao {
    @Query("SELECT * FROM users ORDER BY id ASC")
    fun findAll(): Single<List<UserDb>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(users: List<UserDb>): Completable

    @Query("DELETE FROM users")
    fun deleteAll(): Completable
}
