package com.darkkillen.kotlinaac.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by darkkillen on 10/2/2017 AD.
 */
class SampleModel {

    @SerializedName("foo")
    @Expose
    var foo: String? = null
    @SerializedName("bar")
    @Expose
    var bar: String? = null
    @SerializedName("baz")
    @Expose
    var baz: String? = null
}