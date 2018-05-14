package com.darkkillen.kotlinaac.di.component

import android.app.Application
import com.darkkillen.kotlinaac.di.module.*
import com.darkkillen.kotlinaac.di.scope.ApplicationScope
import com.darkkillen.kotlinaac.template.viewmodel.TemplateViewModel
import com.darkkillen.kotlinaac.viewmodel.activity.MainViewModel
import dagger.Component

/**
 * Created by darkkillen on 9/5/2017 AD.
 */
@ApplicationScope
@Component(
        modules = arrayOf(
                ApplicationModule::class,
                LocalDataModule::class,
                RemoteDataModule::class,
                AppExecutorsModule::class,
                UserRepositoryModule::class

        )
)
interface AppComponent {
    fun inject(application: Application)

    fun inject(mainViewModel: MainViewModel)

    fun inject(templateViewModel: TemplateViewModel)

}
