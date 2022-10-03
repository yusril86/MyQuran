package com.yusril.myquran.ui.surah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.yusril.myquran.adapter.SurahAdapter
import com.yusril.myquran.databinding.ActivityMainBinding
import com.yusril.myquran.databinding.ActivitySurahBinding
import com.yusril.myquran.utils.Resource
import retrofit2.Response

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
        viewModel.fetchDataSurah()
        viewModel.getListSurah().observe(this) {


                when (it) {
                    is Resource.Success -> {
                        binding.rvSurah.apply {
                            setHasFixedSize(true)
                            adapter = adapterSurah
                        }
                        adapterSurah.updateAdapter((listOf(it.data?.data!!)))
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