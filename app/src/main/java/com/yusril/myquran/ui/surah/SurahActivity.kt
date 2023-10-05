package com.yusril.myquran.ui.surah

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.yusril.myquran.adapter.SurahAdapter
import com.yusril.myquran.data.local.room.QuranDatabase
import com.yusril.myquran.data.local.room.SurahDao
import com.yusril.myquran.databinding.ActivitySurahBinding
import com.yusril.myquran.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SurahActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySurahBinding
    private val viewModel: SurahViewModel by viewModels()
    private val adapterSurah: SurahAdapter = SurahAdapter()
    private lateinit var surahDao: SurahDao
    private lateinit var quranDatabase: QuranDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySurahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSurah()
    }

    private fun getSurah() {
        viewModel.surahFetchData.observe(this) { result ->
            when (result) {
                is Resource.Loading -> {
                    // Tampilkan indikator loading
                    binding.pbSurah.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    val surahs = result.data
                    // Tampilkan data surahs di UI
                    binding.pbSurah.visibility = View.GONE
                    binding.rvSurah.apply {
                        setHasFixedSize(true)
                        adapter = adapterSurah
                    }
                    adapterSurah.updateAdapter((surahs!!))

                }
                is Resource.Error -> {
                    val errorMessage = result.message
                    binding.pbSurah.visibility = View.GONE
                    Toast.makeText(this, "$errorMessage", Toast.LENGTH_SHORT).show()
                    // Tampilkan pesan kesalahan di UI
                }
            }
        }
    }
}



