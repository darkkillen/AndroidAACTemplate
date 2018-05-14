package com.darkkillen.kotlinaac.repository.user

import android.arch.lifecycle.LiveData
import android.support.annotation.NonNull
import com.darkkillen.kotlinaac.constant.Constants
import com.darkkillen.kotlinaac.data.model.UserModel
import com.darkkillen.kotlinaac.data.model.base.ApiResponse
import com.darkkillen.kotlinaac.data.model.base.Resource
import com.darkkillen.kotlinaac.data.model.result.UserResult
import com.darkkillen.kotlinaac.data.model.result.UsersResult
import com.darkkillen.kotlinaac.local.UserDao
import com.darkkillen.kotlinaac.remote.UserApi
import com.darkkillen.kotlinaac.repository.AppExecutors
import com.darkkillen.kotlinaac.repository.NetworkBoundResource
import com.darkkillen.kotlinaac.utils.RateLimiter
import io.reactivex.Scheduler
import java.util.concurrent.TimeUnit

class UserRepositoryImpl(val localSource: UserDao, val remoteSource: UserApi, val scheduler: Scheduler, val appExecutors: AppExecutors) : UserRepository {

//    private val userRateLimit = RateLimiter<String>(10, TimeUnit.MINUTES)

    override fun getUser(isForceFetch:Boolean):LiveData<Resource<UserModel>> {
        return object:NetworkBoundResource<UserModel, UsersResult>(appExecutors) {
            override fun saveCallResult(items: UsersResult) {
                for (item in items.data) {
                    localSource.insertOrUpdateUser(item)
                }
            }

            override fun shouldFetch(data:UserModel?):Boolean {
                return isForceFetch || data == null
//                return isForceFetch || data == null || userRateLimit.shouldFetch(Constants.FETCH_KEY_USER)
            }
            @NonNull
            override fun loadFromDb():LiveData<UserModel> {
                return localSource.getUser()
            }
            @NonNull
            override fun createCall(): LiveData<ApiResponse<UsersResult>> {
                return remoteSource.getUser()
            }

            override fun onFetchFailed() {
//                userRateLimit.reset(Constants.FETCH_KEY_USER)
            }

        }.asLiveData()
    }




}
