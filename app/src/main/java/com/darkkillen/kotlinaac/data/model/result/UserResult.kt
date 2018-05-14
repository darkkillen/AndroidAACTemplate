package com.darkkillen.kotlinaac.data.model.result

import com.darkkillen.kotlinaac.data.model.UserModel
import com.google.gson.annotations.SerializedName


/**
 * Created by darkkillen on 10/3/2017 AD.
 */
class UserResult {

    lateinit var status: String
    lateinit var message: String
    @SerializedName("responseObject")
    lateinit var data:UserModel

}
