package com.yusril.myquran

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.yusril.myquran.adapter.SurahAdapter
import com.yusril.myquran.databinding.ActivityMainBinding
import com.yusril.myquran.ui.dashboard.DashboardViewModel
import com.yusril.myquran.ui.surah.SurahActivity
import com.yusril.myquran.ui.surah.SurahViewModel

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