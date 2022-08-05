package com.humam.samplechapter5.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.humam.samplechapter5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.btnGoToPage2?.setOnClickListener {
            var intentGotoPage2 = Intent(this, SecondActivity::class.java)
            startActivity(intentGotoPage2)
            finish() //untuk mendestroy activity yang sebelumnya, sehingga tidak bisa kembali ke activity sebelumnya.
        }
        Log.d("TestLifecycle1", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("TestLifecycle1", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TestLifecycle1", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TestLifecycle1", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TestLifecycle1", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TestLifecycle1", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TestLifecycle1", "onRestart")
    }
}