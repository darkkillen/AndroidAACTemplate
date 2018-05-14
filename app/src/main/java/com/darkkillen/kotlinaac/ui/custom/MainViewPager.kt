package com.darkkillen.kotlinaac.ui.custom

import android.content.Context
import android.support.v4.view.ViewPager
import android.view.MotionEvent
import android.util.AttributeSet

/**
 * Created by darkkillen on 9/28/2017 AD.
 */
class MainViewPager(context:Context, attrs:AttributeSet):ViewPager(context, attrs) {
    internal var enabled:Boolean = false
    init{
        this.enabled = true
    }
    override fun onTouchEvent(event: MotionEvent):Boolean {
        if (this.enabled)
        {
            return super.onTouchEvent(event)
        }
        return false
    }
    override fun onInterceptTouchEvent(event:MotionEvent):Boolean {
        if (this.enabled) return super.onInterceptTouchEvent(event)
        return false
    }
    fun setPagingEnabled(enabled:Boolean) {
        this.enabled = enabled
    }
}