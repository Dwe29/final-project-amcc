package com.example.ter_nak.fragment

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ter_nak.R
import kotlinx.android.synthetic.main.activity_for_you.*

class ForYouActivity : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_for_you, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = this.activity!!.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)
        val username = pref.getString("USERNAME", "")

        textImage.text = "$username!!"
    }
}