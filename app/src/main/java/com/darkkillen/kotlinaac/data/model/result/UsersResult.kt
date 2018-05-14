package com.darkkillen.kotlinaac.data.model.result

import com.darkkillen.kotlinaac.data.model.UserModel
import com.google.gson.annotations.SerializedName

/**
 * Created by darkkillen on 10/24/2017 AD.
 */
class UsersResult {

    @SerializedName("responseObject")
    lateinit var data: List<UserModel>
}