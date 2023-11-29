package com.example.kotlinproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlinproject.databinding.ActivitySplashScreenBinding
import okhttp3.OkHttpClient
import okhttp3.Request


class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        window?.statusBarColor = resources.getColor(R.color.light_grey)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            logo.alpha = 0f
            logo.animate().setDuration(1500).alpha(1f).withEndAction{
                val intent = Intent(this@SplashScreen, HomeScreen::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
        }

    }
}
