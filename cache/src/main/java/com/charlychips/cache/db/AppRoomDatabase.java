package com.charlychips.cache.db;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.charlychips.cache.dao.UserDao;
import com.charlychips.cache.models.UserDb;

@Database(
        entities = {
                UserDb.class,
        }
        , version = 1, exportSchema = false
)
public abstract class AppRoomDatabase extends RoomDatabase {
    private static volatile AppRoomDatabase INSTANCE;

    public abstract UserDao userDao();


    public static AppRoomDatabase getIntance(final Application application) {
        if (INSTANCE == null) {
            synchronized (AppRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(application,
                            AppRoomDatabase.class, "clean.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
