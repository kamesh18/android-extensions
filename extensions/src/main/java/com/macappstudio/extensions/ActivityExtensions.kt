package com.macappstudio.extensions

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.launchActivity(javaClass: Class<out AppCompatActivity>, bundle: Bundle? = null, isClearPreviousTask: Boolean = false) {
    Intent(this, javaClass).apply {
        if (bundle != null)
            putExtras(bundle)

        if (isClearPreviousTask)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        startActivity(this)
    }
}

fun AppCompatActivity.launchActivityForResult(javaClass: Class<out AppCompatActivity>, requestCode: Int, bundle: Bundle? = null) {
    Intent(this, javaClass).apply {
        if (bundle != null)
            putExtras(bundle)

        startActivityForResult(this, requestCode)
    }
}

fun AppCompatActivity.pixelDp(size: Int): Int {
    return (size * (resources.displayMetrics.density)).toInt()
}