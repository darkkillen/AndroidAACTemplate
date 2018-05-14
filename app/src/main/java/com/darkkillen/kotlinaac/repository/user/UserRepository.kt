package com.darkkillen.kotlinaac.repository.user

import android.arch.lifecycle.LiveData
import com.darkkillen.kotlinaac.data.model.UserModel
import com.darkkillen.kotlinaac.data.model.base.Resource

interface UserRepository {

    fun getUser(isForceFetch:Boolean):LiveData<Resource<UserModel>>

}
