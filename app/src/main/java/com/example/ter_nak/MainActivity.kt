package com.example.ter_nak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.viewpager.widget.ViewPager
import com.example.ter_nak.produk.ProdukAyambroilerActivity
import com.example.ter_nak.produk.ProdukAyamkampungActivity
import com.example.ter_nak.produk.ProdukAyamkubActivity
import com.example.ter_nak.produk.ProdukAyampetelurActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var currentPage = 0
    private var numPages = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Move activity
        ayam_kampung.setOnClickListener {
            val intent = Intent(this, ProdukAyamkampungActivity::class.java)
            startActivity(intent)
        }

        ayam_broiler.setOnClickListener {
            val intent = Intent(this, ProdukAyambroilerActivity::class.java)
            startActivity(intent)
        }

        ayam_petelur.setOnClickListener {
            val intent = Intent(this, ProdukAyampetelurActivity::class.java)
            startActivity(intent)
        }

        ayam_kub.setOnClickListener {
            val intent = Intent(this, ProdukAyamkubActivity::class.java)
            startActivity(intent)
        }

        val assets = listOf(
            R.drawable.ayamkampung01,
            R.drawable.ayambroiler03,
            R.drawable.ayampetelur02,
            R.drawable.ayamkub03
        )

        createSlider(assets)
    }

    private fun createSlider(string: List<Int>) {
        vpSlider.adapter = SliderAdapter(this, string)
        indicator.setViewPager(vpSlider)
        val density = resources.displayMetrics.density
        //Set Circle indicator radius
        indicator.radius = 5 * density
        numPages = string.size
        // Auto getData of viewpager
        val update = Runnable {
            if (currentPage === numPages) {
                currentPage = 0
            }
            vpSlider.setCurrentItem(currentPage++, true)
        }
        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                Handler(Looper.getMainLooper()).post(update)
            }
        }, 5000, 5000)
        // Pager listener over indicator
        indicator.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                currentPage = position
            }

            override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(pos: Int) {}
        })
    }


}