package com.bchmsl.homework3

import android.util.Patterns
import java.lang.Exception


sealed class InputField {

    abstract fun checkField(inputValue: String): Boolean

    object PersonFirstName : InputField() {
        override fun checkField(inputValue: String): Boolean {
            return (inputValue.isNotEmpty())
        }
    }

    object PersonLastName : InputField() {
        override fun checkField(inputValue: String): Boolean {
            return (inputValue.isNotEmpty())
        }
    }

    object Email : InputField() {
        override fun checkField(inputValue: String): Boolean {
            return Patterns.EMAIL_ADDRESS.matcher(inputValue).matches()
        }

    }

    object Username : InputField() {
        override fun checkField(inputValue: String): Boolean {
            return inputValue.length >= 10
        }

    }

    object Age : InputField() {
        override fun checkField(inputValue: String): Boolean {
            val result: Int
            try {
                result = inputValue.toInt()
            } catch (e: Exception) {
                return false
            }
            return result in 0..200
        }

    }

}
