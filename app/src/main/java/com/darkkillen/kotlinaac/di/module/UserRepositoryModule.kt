package com.darkkillen.kotlinaac.di.module

import com.darkkillen.kotlinaac.di.scope.ApplicationScope
import com.darkkillen.kotlinaac.local.UserDao
import com.darkkillen.kotlinaac.remote.UserApi
import com.darkkillen.kotlinaac.repository.AppExecutors
import com.darkkillen.kotlinaac.repository.user.UserRepository
import com.darkkillen.kotlinaac.repository.user.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

/**
 * Created by darkkillen on 10/3/2017 AD.
 */
@Module
class UserRepositoryModule {

    @Provides
    @ApplicationScope
    fun provideUserRepository(localSource: UserDao, remoteSource: UserApi, appExecutors: AppExecutors): UserRepository
            = UserRepositoryImpl(localSource, remoteSource, Schedulers.io(), appExecutors)
}

