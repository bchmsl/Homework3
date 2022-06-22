package com.bchmsl.homework3

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.bchmsl.homework3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        init()
    }

    private fun init() {
        listeners()
    }

    private fun listeners() {
        val etFirstName = binding.etFirstName
        val etLastName = binding.etLastName
        val etEmail = binding.etEmail
        val etUsername = binding.etUsername
        val etAge = binding.etAge
        val allEditTexts = arrayOf(etFirstName, etLastName, etEmail, etUsername, etAge)


        binding.btnSave.setOnClickListener {
            setColor(*allEditTexts, color = Color.WHITE)

            if (fieldsCheck(etFirstName, etLastName, etEmail, etUsername, etAge)) {
                enable(*allEditTexts, enabled = false)

                this.showSnackBar(binding.root, "Saved Successfully!")
            } else {
                this.showSnackBar(binding.root, "Please check fields and try again!")
            }
        }

        binding.btnClear.setOnLongClickListener {

            allEditTexts.apply {
                setColor(*this, color = Color.WHITE)
                clear(*this)
                enable(*this, enabled = false)
            }



            this.showSnackBar(binding.root, "All fields cleared!")
            true
        }

        binding.btnClear.setOnClickListener {
            this.showSnackBar(binding.root, "Press and hold to clear fields!")
        }
    }

    private fun fieldsCheck(
        etFirstName: AppCompatEditText,
        etLastName: AppCompatEditText,
        etEmail: AppCompatEditText,
        etUsername: AppCompatEditText,
        etAge: AppCompatEditText
    ): Boolean {
        val firstName = etFirstName.text.toString()
        val lastName = etLastName.text.toString()
        val email = etEmail.text.toString()
        val username = etUsername.text.toString()
        val age = etAge.text.toString()
        var fieldsCorrect = true

        if (!InputField.PersonFirstName.checkField(firstName)) {
            setColor(etFirstName, color = Color.RED)
            fieldsCorrect = false
        }
        if (!InputField.PersonLastName.checkField(lastName)) {
            setColor(etLastName, color = Color.RED)
            fieldsCorrect = false
        }
        if (!InputField.Email.checkField(email)) {
            setColor(etEmail, color = Color.RED)
            fieldsCorrect = false

        }
        if (!InputField.Username.checkField(username)) {
            setColor(etUsername, color = Color.RED)
            fieldsCorrect = false
        }
        if (!InputField.Age.checkField(age)) {
            setColor(etAge, color = Color.RED)
            fieldsCorrect = false
        }
        return fieldsCorrect
    }


}