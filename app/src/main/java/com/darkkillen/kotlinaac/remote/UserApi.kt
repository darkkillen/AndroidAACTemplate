package com.darkkillen.kotlinaac.remote

import android.arch.lifecycle.LiveData
import com.darkkillen.kotlinaac.data.model.UserModel
import com.darkkillen.kotlinaac.data.model.base.ApiResponse
import com.darkkillen.kotlinaac.data.model.result.UserResult
import com.darkkillen.kotlinaac.data.model.result.UsersResult
import retrofit2.http.GET

/**
 * Created by darkkillen on 10/3/2017 AD.
 */
interface UserApi {

    @GET("59eebd372e0000e5021c5bf8") // list
//    @GET("59da257d100000c811caf1c9") // single
//    @GET("59d3102a11000009044a05fe")
    fun getUser(): LiveData<ApiResponse<UsersResult>>



}
