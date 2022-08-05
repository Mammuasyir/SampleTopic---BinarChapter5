package com.humam.samplechapter5.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.humam.samplechapter5.R
import com.humam.samplechapter5.adapter.ViewPagerAdapter
import com.humam.samplechapter5.databinding.ActivitySlidingBinding

class SlidingActivity : AppCompatActivity() {

    var binding : ActivitySlidingBinding? = null

    val tabTitle = arrayOf("Sample 1", "Sample 2")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySlidingBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val viewPagerAdapter = ViewPagerAdapter(this)
        binding?.vpFragment?.adapter = viewPagerAdapter

        binding?.let {
            TabLayoutMediator(it.tlFragment, it.vpFragment) { tab, position ->
                tab.text = tabTitle[position]
            }.attach()
        }
    }
}