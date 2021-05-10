package com.example.ter_nak

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            val userName = etUsername.text.toString()
            val passWord = etPassword.text.toString()

            if (userName.isEmpty() || passWord.isEmpty()) {
                Toast.makeText(this, "Username dan Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            } else {
                saveLogin(userName, passWord)
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }

    private fun saveLogin(username: String, password: String) {
        val pref = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)
        val setValuePref = pref.edit()
        setValuePref.putString("USERNAME",username)
        setValuePref.putString("PASSWORD",password)
        setValuePref.apply()
    }

}