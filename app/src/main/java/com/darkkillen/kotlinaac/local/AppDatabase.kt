package com.darkkillen.kotlinaac.local

/**
 * Created by darkkillen on 10/3/2017 AD.
 */
import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.darkkillen.kotlinaac.data.model.UserModel

@Database(entities = arrayOf(UserModel::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}

