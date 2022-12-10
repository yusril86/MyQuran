package com.yusril.myquran.ui.surah

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.yusril.myquran.adapter.SurahAdapter
import com.yusril.myquran.databinding.ActivitySurahBinding
import com.yusril.myquran.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SurahActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySurahBinding
    private val viewModel: SurahViewModel by viewModels()
    private val adapterSurah: SurahAdapter = SurahAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySurahBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSurah()
    }

    private fun getSurah() {
        viewModel.getListSurah().observe(this) {

                when (it) {
                    is Resource.Success -> {
                        binding.rvSurah.apply {
                            setHasFixedSize(true)
                            adapter = adapterSurah
                        }
                        adapterSurah.updateAdapter((it.data!!))
                    }

                    is Resource.Loading -> {
                        /*ProgressbarDialog*/
                    }

                    is Resource.Error -> {

                    }

            }
        }
    }
}