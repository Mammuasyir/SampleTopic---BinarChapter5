package com.humam.samplechapter5.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.humam.samplechapter5.R
import com.humam.samplechapter5.activity.SampleIntentActivity.Companion.KEY_NAME_DATA
import com.humam.samplechapter5.activity.SampleIntentActivity.Companion.KEY_USER
import com.humam.samplechapter5.activity.SampleIntentActivity.Companion.KEY_USER_PARCELIZE
import com.humam.samplechapter5.databinding.ActivitySecondBinding
import com.humam.samplechapter5.model.User
import com.humam.samplechapter5.model.UserParcelize

class SecondActivity : AppCompatActivity() {

    var binding : ActivitySecondBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val data = intent.getStringExtra(KEY_NAME_DATA)
        val user = intent.getSerializableExtra(KEY_USER) as User

        val userParcelize = intent.getParcelableExtra<UserParcelize>(KEY_USER_PARCELIZE)

        binding?.apply {
            tvShowData.text = userParcelize?.name.orEmpty()
        }
    }
}