package com.humam.samplechapter5.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.humam.samplechapter5.R
import com.humam.samplechapter5.fragment.SampleFragment

class ContainerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        val sampleFragment = SampleFragment()
        fragmentTransaction.add(R.id.fcvSample, sampleFragment)
        fragmentTransaction.commit()
        Log.d("ContainerActivity", "onCreate")

    }

    override fun onStart() {
        super.onStart()
        Log.d("ContainerActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ContainerActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ContainerActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ContainerActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ContainerActivity", "onDestroy")
    }
}