package com.darkkillen.kotlinaac.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by darkkillen on 10/3/2017 AD.
 */
@Entity(tableName = "user")
class UserModel {

    @ColumnInfo(name = "user")
    @SerializedName("user")
    lateinit var user: String

    @ColumnInfo(name = "token")
    @SerializedName("token")
    lateinit var token: String

}
