package com.darkkillen.kotlinaac.ui.custom.base.state

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import android.view.View

/**
 * Created by darkkillen on 9/28/2017 AD.
 */
class BundleSavedState: View.BaseSavedState {
    var bundle = Bundle()
    constructor(source: Parcel) : super(source) {
        bundle = source.readBundle()
    }
    constructor(superState: Parcelable) : super(superState) {}
    override fun writeToParcel(out:Parcel, flags:Int) {
        super.writeToParcel(out, flags)
        out.writeBundle(bundle)
    }
    companion object {
        val CREATOR:Creator<Any> = object: Creator<Any> {
            override fun createFromParcel(source:Parcel):Any {
                return BundleSavedState(source)
            }
            override fun newArray(size:Int): Array<BundleSavedState?> {
                return arrayOfNulls<BundleSavedState>(size)
            }
        }
    }
}