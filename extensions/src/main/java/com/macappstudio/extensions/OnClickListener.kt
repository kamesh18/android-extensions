package com.macappstudio.extensions

import android.os.SystemClock
import android.view.View
import java.util.*
import kotlin.math.abs

abstract class OnClickListener : View.OnClickListener {
    private val lastClickMap: MutableMap<View, Long>
    private val minIntervalMillis: Long = 1000L // Need to set the required value

    init {
        this.lastClickMap = WeakHashMap()
    }

    /**
     * Implement this in your subclass instead of onClick
     * @param view The view that was clicked
     */
    abstract fun onClickListener(view: View)

    override fun onClick(clickedView: View) {
        val previousClickTimestamp = lastClickMap[clickedView]
        val currentTimestamp = SystemClock.uptimeMillis()

        lastClickMap[clickedView] = currentTimestamp
        if (previousClickTimestamp == null || abs(currentTimestamp - previousClickTimestamp) > minIntervalMillis) {
            onClickListener(clickedView)
        }
    }
}