package com.macappstudio.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.showKeyboard() {
    this.requestFocus()
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun View.hideKeyboard() {
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}

fun View.setOnclickListener(onClick: (View) -> Unit) {
    val setOnClickListener = object : OnClickListener() {

        override fun onClickListener(view: View) {
            onClick(view)
        }
    }
    setOnClickListener(setOnClickListener)
}