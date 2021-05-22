package com.example.ter_nak.product

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.ter_nak.activity.LoginActivity
import com.example.ter_nak.R
import com.example.ter_nak.activity.SliderAdapter
import com.example.ter_nak.description.DescriptionAyampetelurActivity
import kotlinx.android.synthetic.main.activity_produk_ayampetelur.*

class ProdukAyampetelurActivity : AppCompatActivity() {

    private var currentPage = 0
    private var numPages = 0
    private val loginActivity = LoginActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produk_ayampetelur)

        val assets = listOf(
            R.drawable.ayampetelur01,
            R.drawable.ayampetelur02,
            R.drawable.ayampetelur03
        )

        createSlider(assets)

        val pref = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)
        val username = pref.getString("USERNAME", "")
        val password = pref.getString("PASSWORD", "")

        // when click beli
        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            beliPetelur.setOnClickListener {
                Toast.makeText(this,
                    "Silahkan Login Terlebih Dahulu Untuk Membeli",
                    Toast.LENGTH_LONG).show()
                startActivity(Intent(this, loginActivity::class.java))
            }
        } else {
            // Move to WhatsApp
            val number = "6281247571525"
            val url: String = "https://api.whatsapp.com/send?phone=" + number
            beliPetelur.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setPackage("com.whatsapp")
                intent.data = Uri.parse(url)
                startActivity(intent)
            }
        }

        // when click deskripsi
        descPetelur.setOnClickListener{
            startActivity(Intent(this, DescriptionAyampetelurActivity::class.java))
        }
    }

    private fun createSlider(string: List<Int>) {
        vpSliderPetelur.adapter = SliderAdapter(this, string)
        indicatorPetelur.setViewPager(vpSliderPetelur)
        val density = resources.displayMetrics.density
        //Set Circle indicator radius
        indicatorPetelur.radius = 5 * density
        numPages = string.size
        // Pager listener over indicator
        indicatorPetelur.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                currentPage = position
            }

            override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(pos: Int) {}
        })
    }
}