package com.yusril.myquran.ui.ayat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.yusril.myquran.R
import com.yusril.myquran.adapter.AyatAdapter
import com.yusril.myquran.databinding.ActivityAyatBinding
import com.yusril.myquran.databinding.ActivitySurahBinding
import com.yusril.myquran.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AyatActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAyatBinding
    private val viewModel : AyatViewModel by viewModels()
    private lateinit var numberAyat :String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAyatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getAyat()
    }

    private fun getAyat(){
        numberAyat = intent.getStringExtra("nomor_surah").toString()
        viewModel.getAyat(numberAyat).observe(this){
            when(it){
                is Resource.Success ->{
                    binding.pbAyat.visibility = View.GONE
                    binding.rvAyat.apply {
                        adapter = AyatAdapter(this@AyatActivity, it.data!!)
                        setHasFixedSize(true)
                    }
                }

                is Resource.Loading->{
                    binding.pbAyat.visibility = View.VISIBLE
                }

                is Resource.Error->{
                    binding.pbAyat.visibility = View.GONE
                }
            }
        }
    }
}