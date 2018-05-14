package com.darkkillen.kotlinaac

import android.app.Application
import com.darkkillen.kotlinaac.di.component.AppComponent
import com.darkkillen.kotlinaac.di.component.DaggerAppComponent
import com.darkkillen.kotlinaac.di.module.LocalDataModule
import com.darkkillen.kotlinaac.di.module.RemoteDataModule
import com.darkkillen.kotlinaac.di.module.UserRepositoryModule
import com.darkkillen.kotlinaac.di.module.AppExecutorsModule

/**
 * Created by darkkillen on 9/5/2017 AD.
 */
class MainApplication: Application() {

    companion object {
        lateinit var component: AppComponent
    }

    private val BASE_URL = " http://www.mocky.io/v2/"

    override fun onCreate() {
        super.onCreate()
        buildDependencyGraph()
    }

    private fun buildDependencyGraph() {
        component = DaggerAppComponent.builder()
                .localDataModule(LocalDataModule(applicationContext))
                .remoteDataModule(RemoteDataModule(BASE_URL))
                .appExecutorsModule(AppExecutorsModule())
                .userRepositoryModule(UserRepositoryModule())
                .build()
    }
}