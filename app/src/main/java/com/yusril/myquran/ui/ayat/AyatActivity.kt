package com.yusril.myquran.ui.ayat

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.yusril.myquran.R
import com.yusril.myquran.adapter.AyatAdapter
import com.yusril.myquran.data.local.entity.AyatEntity
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
                        adapter = AyatAdapter( it.data!!).apply {
                            onItemClick ={ item->
                                showDialog(item.arabAyat, item.artiAyat,item.nomorAyat,AyatEntity(item.nomorAyat.toInt(),item.nomorAyat,item.arabAyat,item.artiAyat,item.transliterasi,false) )
                            }
                        }
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

    private fun showDialog(ayat: String, artiAyat : String, noAyat:String, ayatEntity: AyatEntity){
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.layout_bottom_sheet)
        val btnCopy = dialog.findViewById<LinearLayout>(R.id.btnCopy)
        val btnBookmark = dialog.findViewById<LinearLayout>(R.id.btnBookmark)


        btnCopy?.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip: ClipData = ClipData.newPlainText("simple text", "$ayat \n $artiAyat")
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "BTN COPY", Toast.LENGTH_SHORT).show()
        }

        /*btnBookmark?.setOnClickListener {
            if (ayatEntity.isBookmarked){
                viewModel.saveAyat(ayatEntity)
            }else{
                viewModel.deleteAyat(ayatEntity)
            }
        }*/

        dialog.show()
    }
}