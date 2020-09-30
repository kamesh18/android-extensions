package com.macappstudio.extensions

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Fragment.launchActivity(javaClass: Class<out AppCompatActivity>, bundle: Bundle? = null, isClearPreviousTask: Boolean = false) {
    Intent(requireContext(), javaClass).apply {
        if (bundle != null) {
            putExtras(bundle)
        }

        if (isClearPreviousTask)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        startActivity(this)
    }
}

fun Fragment.launchActivityForResult(javaClass: Class<out AppCompatActivity>, requestCode: Int, bundle: Bundle? = null) {
    Intent(activity, javaClass).apply {
        if (bundle != null)
            putExtras(bundle)

        startActivityForResult(this, requestCode)
    }
}

fun Fragment.pixelDp(size: Int): Int {
    return (size * (resources.displayMetrics.density)).toInt()
}