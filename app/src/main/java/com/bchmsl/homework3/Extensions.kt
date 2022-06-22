package com.bchmsl.homework3

import android.content.Context
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import com.google.android.material.snackbar.Snackbar


fun setColor(vararg editText: AppCompatEditText, color: Int){
    editText.forEach {
        it.setBackgroundColor(color)
    }
}

fun enabled(vararg editText: AppCompatEditText, enabled: Boolean){
    editText.forEach {
        it.isEnabled = enabled
    }
}

fun clear(vararg editText: AppCompatEditText){
    editText.forEach {
        it.text?.clear()
    }
}

fun Context.showSnackBar(view: View, text: String){
    Snackbar.make(this, view, text, Snackbar.LENGTH_SHORT).show()
}