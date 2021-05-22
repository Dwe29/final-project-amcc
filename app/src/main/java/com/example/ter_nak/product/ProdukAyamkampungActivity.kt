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
import com.example.ter_nak.description.DescriptionAyamkampungActivity
import kotlinx.android.synthetic.main.activity_produk_ayamkampung.*

class ProdukAyamkampungActivity : AppCompatActivity() {

    private var currentPage = 0
    private var numPages = 0
    private val loginActivity = LoginActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produk_ayamkampung)

        val assets = listOf(
            R.drawable.ayamkampung01,
            R.drawable.ayamkampung02,
            R.drawable.ayamkampung03
        )

        createSlider(assets)

        val pref = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)
        val username = pref.getString("USERNAME", "")
        val password = pref.getString("PASSWORD", "")

        // when click beli
        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            beliKampung.setOnClickListener {
                Toast.makeText(this,
                    "Silahkan Login Terlebih Dahulu Untuk Membeli",
                    Toast.LENGTH_LONG).show()
                startActivity(Intent(this, loginActivity::class.java))
            }
        } else {
            // Move to WhatsApp
            val number = "6281247571525"
            val url: String = "https://api.whatsapp.com/send?phone=" + number
            beliKampung.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setPackage("com.whatsapp")
                intent.data = Uri.parse(url)
                startActivity(intent)
            }
        }

        // when click deskripsi
        descKampung.setOnClickListener {
            startActivity(Intent(this, DescriptionAyamkampungActivity::class.java))
        }
    }

    private fun createSlider(string: List<Int>) {
        vpSliderKampung.adapter = SliderAdapter(this, string)
        indicatorKampung.setViewPager(vpSliderKampung)
        val density = resources.displayMetrics.density
        //Set Circle indicator radius
        indicatorKampung.radius = 5 * density
        numPages = string.size
        // Pager listener over indicator
        indicatorKampung.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                currentPage = position
            }

            override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(pos: Int) {}
        })
    }
}