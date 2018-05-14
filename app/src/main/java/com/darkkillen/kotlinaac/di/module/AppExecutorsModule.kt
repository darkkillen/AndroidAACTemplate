package com.darkkillen.kotlinaac.di.module

import com.darkkillen.kotlinaac.di.scope.ApplicationScope
import com.darkkillen.kotlinaac.repository.AppExecutors
import dagger.Module
import dagger.Provides

/**
 * Created by darkkillen on 10/8/2017 AD.
 */
@Module
class AppExecutorsModule {

    @Provides
    @ApplicationScope
    fun provideAppExecutors(): AppExecutors {
        return AppExecutors.instance
    }

}

