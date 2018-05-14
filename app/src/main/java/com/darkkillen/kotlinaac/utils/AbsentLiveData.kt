package com.darkkillen.kotlinaac.utils

import android.arch.lifecycle.LiveData

/**
 * A LiveData class that has `null` value.
 */
class AbsentLiveData<T>: LiveData<T>() {
    init {
        postValue(null)
    }

    companion object {
        fun <T> create(): LiveData<T> {

            return AbsentLiveData()
        }
    }
}