package com.darkkillen.kotlinaac.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.darkkillen.kotlinaac.data.model.UserModel

/**
 * Created by darkkillen on 10/3/2017 AD.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateUser(vararg user: UserModel)

    @Query("SELECT * FROM user LIMIT 1")
    fun getUser(): LiveData<UserModel>

}

