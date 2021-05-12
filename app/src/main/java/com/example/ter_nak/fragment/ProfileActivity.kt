package com.example.ter_nak.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.ter_nak.LoginActivity
import com.example.ter_nak.MainActivity
import com.example.ter_nak.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = this.activity!!.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)
        val username = pref.getString("USERNAME", "")
        val password = pref.getString("PASSWORD", "")

        usernameProfile.setText(username)
        passwordProfile.setText(password)

        btnLogout.setOnClickListener {
            val editor = pref.edit()
            editor.clear()
            editor.apply()
            val intent = Intent(activity!!, MainActivity::class.java)
            startActivity(intent)
            activity!!.finish()
        }

    }
}