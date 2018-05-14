package com.darkkillen.kotlinaac.viewmodel.activity

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.darkkillen.kotlinaac.data.model.UserModel
import com.darkkillen.kotlinaac.data.model.base.Resource
import com.darkkillen.kotlinaac.repository.user.UserRepository
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by darkkillen on 9/5/2017 AD.
 */
class MainViewModel: ViewModel() {

    @Inject
    lateinit var userRepo: UserRepository

    private var user: LiveData<UserModel>? = null

    fun getUser(): LiveData<Resource<UserModel>> {
        return userRepo.getUser(true)
    }

}