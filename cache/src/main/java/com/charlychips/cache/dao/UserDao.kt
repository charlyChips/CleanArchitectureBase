package com.charlychips.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.charlychips.cache.models.UserDb

@Dao
interface UserDao {
    @Query("SELECT * FROM users ORDER BY id ASC")
    fun findAll(): List<UserDb>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(users: List<UserDb>)

    @Query("DELETE FROM users")
    fun deleteAll()
}
