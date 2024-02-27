package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val emailField: TextView = findViewById(R.id.textEmail)
        val passwordField: TextView = findViewById(R.id.textPassword)
        val loginBtn : Button = findViewById(R.id.btnLogin)


        loginBtn.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString();

            val intent = Intent(this, TodoListActivity::class.java)
            intent.putExtra("username", email)
            startActivity(intent)
        }
    }
}