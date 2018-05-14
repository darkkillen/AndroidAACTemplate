package com.darkkillen.kotlinaac.di.module

import android.app.Application
import android.content.Context
import com.darkkillen.kotlinaac.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

/**
 * Created by darkkillen on 9/5/2017 AD.
 */
@Module
class ApplicationModule(val application: Application) {

    @Provides
    @ApplicationScope
    fun provideApplication() : Application {
        return application
    }

    @Provides
    @ApplicationScope
    fun provideContext() : Context {
        return application
    }

}
