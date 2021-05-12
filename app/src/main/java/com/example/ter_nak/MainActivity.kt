package com.example.ter_nak

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.ter_nak.fragment.ForYouActivity
import com.example.ter_nak.fragment.HomeActivity
import com.example.ter_nak.fragment.ProfileActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_mainv2.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val profileActivity = ProfileActivity()
    private val homeActivity = HomeActivity()
    private val forYouActivity = ForYouActivity()
    private val loginActivity = LoginActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(forYouActivity)

        // Move to LoginActivity when the pref is empty and move to ProfileActivity when the pref is not empty
        // jika sudah login akan pindah ke ProfileActivity jika belum akan pindah ke LoginActivity
        val pref = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)
        val username = pref.getString("USERNAME", "")
        val password = pref.getString("PASSWORD", "")
        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            bottom_navigation.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.ic_beranda -> replaceFragment(forYouActivity)
                    R.id.ic_home -> replaceFragment(homeActivity)
                    R.id.ic_profile -> {
                        Toast.makeText(this,
                            "Anda Belom Login Silahkan Login terlebih dahulu",
                            Toast.LENGTH_LONG).show()
                        startActivity(Intent(this, loginActivity::class.java))
                    }
                }
                true
            }
        } else {
            bottom_navigation.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.ic_beranda -> replaceFragment(forYouActivity)
                    R.id.ic_home -> replaceFragment(homeActivity)
                    R.id.ic_profile -> replaceFragment(profileActivity)
                }
                true
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}