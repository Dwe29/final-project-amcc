package com.example.ter_nak.produk

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.viewpager.widget.ViewPager
import com.example.ter_nak.R
import com.example.ter_nak.SliderAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_produk_ayambroiler.*
import kotlinx.android.synthetic.main.activity_produk_ayampetelur.*
import java.util.*

class ProdukAyampetelurActivity : AppCompatActivity() {

    private var currentPage = 0
    private var numPages = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produk_ayampetelur)

        val assets = listOf(
            R.drawable.ayampetelur01,
            R.drawable.ayampetelur02,
            R.drawable.ayampetelur03
        )

        createSlider(assets)

        // send
        val number = "6282271222110"
        val url: String = "https://api.whatsapp.com/send?phone=" + number
        beliPetelur.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setPackage("com.whatsapp")
            intent.setData(Uri.parse(url))
            startActivity(intent)
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