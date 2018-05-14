package com.darkkillen.kotlinaac.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.darkkillen.kotlinaac.di.scope.ApplicationScope
import com.darkkillen.kotlinaac.local.AppDatabase
import com.darkkillen.kotlinaac.local.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by darkkillen on 10/3/2017 AD.
 */
@Module
class LocalDataModule(val context: Context) {

    private val DB_FILE_NAME = "user-db"

    @Provides
    @ApplicationScope
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

    @Provides
    @ApplicationScope
    fun provideAppDatabase(): AppDatabase =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_FILE_NAME)
                    .build()
}
