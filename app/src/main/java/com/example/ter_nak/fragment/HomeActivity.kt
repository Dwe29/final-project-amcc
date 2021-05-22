package com.example.ter_nak.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.ter_nak.R
import com.example.ter_nak.activity.SliderAdapter
import com.example.ter_nak.product.ProdukAyambroilerActivity
import com.example.ter_nak.product.ProdukAyamkampungActivity
import com.example.ter_nak.product.ProdukAyamkubActivity
import com.example.ter_nak.product.ProdukAyampetelurActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : Fragment() {

    private var currentPage = 0
    private var numPages = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Move activity
        ayam_kampung.setOnClickListener {
            val intent = Intent(activity!!, ProdukAyamkampungActivity::class.java)
            startActivity(intent)
        }

        ayam_broiler.setOnClickListener {
            val intent = Intent(activity!!, ProdukAyambroilerActivity::class.java)
            startActivity(intent)
        }

        ayam_petelur.setOnClickListener {
            val intent = Intent(activity!!, ProdukAyampetelurActivity::class.java)
            startActivity(intent)
        }

        ayam_kub.setOnClickListener {
            val intent = Intent(activity!!, ProdukAyamkubActivity::class.java)
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

    private fun createSlider(String: List<Int>) {
        vpSlider.adapter = SliderAdapter(activity!!, String)
        indicator.setViewPager(vpSlider)
        val density = resources.displayMetrics.density
        //Set Circle indicator radius
        indicator.radius = 5 * density
        numPages = String.size
//        // Auto getData of viewpager
//        val update = Runnable {
//            if (currentPage == numPages) {
//                currentPage = 0
//            }
//            vpSliderBroiler.setCurrentItem(currentPage++, true)
//        }
//        val swipeTimer = Timer()
//        swipeTimer.schedule(object : TimerTask() {
//            override fun run() {
//                Handler(Looper.getMainLooper()).post(update)
//            }
//        }, 5000, 5000)
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