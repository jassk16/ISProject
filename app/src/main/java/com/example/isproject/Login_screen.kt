package com.example.isproject

import DatabaseHelper
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    lateinit var dbHelper: DatabaseHelper
    lateinit var usernameEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        dbHelper = DatabaseHelper(this)

        usernameEditText = findViewById(R.id.etUsername)
        passwordEditText = findViewById(R.id.etPassword)
        loginButton = findViewById(R.id.login)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                val valid = dbHelper.checkUser(username, password)
                if (valid) {
                    Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                    // Navigate to another activity or perform post-login actions
                } else {
                    Toast.makeText(this, "Invalid credentials.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter all fields.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
