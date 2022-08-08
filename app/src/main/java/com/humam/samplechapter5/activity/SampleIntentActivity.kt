package com.humam.samplechapter5.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.humam.samplechapter5.R
import com.humam.samplechapter5.activity.SecondActivity.Companion.KEY_NAME_DATA
import com.humam.samplechapter5.databinding.ActivitySampleIntentBinding
import com.humam.samplechapter5.model.User
import com.humam.samplechapter5.model.UserParcelize

class SampleIntentActivity : AppCompatActivity() {

    var binding: ActivitySampleIntentBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySampleIntentBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //Implicit Intent
        binding?.apply {
            btnWhatsapp.setOnClickListener {
                try {
                    Intent().apply {
                        setPackage("com.whatsapp")
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, "This is a sample implicit intent")
                        startActivity(this)
                        //mengarahkan ke aplikasi yang ada di device, langsung ke kolom chat whatsapp

                    }
                }catch (e: Exception) {
                    Log.d("Error Intent","Aplikasi tidak ditemukan")
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp")).apply {
                        startActivity(this)
                    }
                }
                //try cath untuk menghindari error jika aplikasi tidak ditemukan
            }

            //Explicit Intent
            btnPage2.setOnClickListener {

                val user = User("Humam", "Laki2")

                val userParcelize = UserParcelize("Humam", "Laki2")

                val intentPage2 = Intent(this@SampleIntentActivity, SecondActivity::class.java)
                val bundle = Bundle()
                bundle.putString(KEY_NAME_DATA, "Hello from Page 1")
//                intentPage2.putExtra(KEY_NAME_DATA, "Hello from Page 1")
//                intentPage2.putExtra(KEY_USER,user)
//                intentPage2.putExtra(KEY_USER_PARCELIZE,userParcelize)
                startActivity(intentPage2)
                //
            }
        }

    }
}