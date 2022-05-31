package com.example.basegrupo2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.findNavController
import com.example.basegrupo2.R
import com.example.basegrupo2.fragments.Fragment1Directions

class LoginActivity : AppCompatActivity() {
    lateinit var btnGoToHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onStart() {
        super.onStart()
        btnGoToHome = findViewById(R.id.btnLogin)
        btnGoToHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}