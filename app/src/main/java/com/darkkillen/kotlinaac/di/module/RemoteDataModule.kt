package com.darkkillen.kotlinaac.di.module

/**
 * Created by darkkillen on 10/3/2017 AD.
 */
import com.darkkillen.kotlinaac.di.scope.ApplicationScope
import com.darkkillen.kotlinaac.remote.UserApi
import com.darkkillen.kotlinaac.utils.LiveDataCallAdapterFactory
import com.darkkillen.kotlinaac.utils.PrettyHttpLogger
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RemoteDataModule(val baseUrl: String) {

    @Provides @ApplicationScope
    fun provideUserApi(retrofit: Retrofit): UserApi
            = retrofit.create(UserApi::class.java)

    @Provides @ApplicationScope
    fun provideRetrofit(): Retrofit
            = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addNetworkInterceptor(getDefaultHttpLoggingInterceptor()).build())
            .build()

    private fun getDefaultHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(PrettyHttpLogger()).setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}

