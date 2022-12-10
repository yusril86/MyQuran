package com.yusril.myquran.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yusril.myquran.databinding.ActivityMainBinding
import com.yusril.myquran.ui.surah.SurahActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSurah.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SurahActivity::class.java
                )
            )
        }
    }
}