package com.example.ter_nak

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val pref = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)
        val username = pref.getString("USERNAME", "")
        val password = pref.getString("PASSWORD", "")

        Handler().postDelayed({
            if (username.isNullOrEmpty() || password.isNullOrEmpty()) startActivity(Intent(this, LoginActivity::class.java))
            else startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)
    }
}