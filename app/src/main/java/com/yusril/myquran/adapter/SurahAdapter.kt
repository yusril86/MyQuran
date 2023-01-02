package com.yusril.myquran.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yusril.myquran.data.response.SurahModel
import com.yusril.myquran.databinding.ItemListSurahBinding
import com.yusril.myquran.ui.ayat.AyatActivity

class SurahAdapter : RecyclerView.Adapter<SurahAdapter.ItemViewHolder>() {
    private val mListSurah : MutableList<SurahModel> = ArrayList()

    fun updateAdapter(list : List<SurahModel>){
        mListSurah.clear()
        mListSurah.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemListSurahBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.apply {
            mListSurah[position].apply {
                tvNameArabicSurah.text = asma
                tvName.text = namaSurah
                tvJumlahAyat.text = jumlahAyat
                tvNoSurah.text = nomorSurah
                tvDaerah.text = daerahType
            }
            holder.itemView.setOnClickListener {
                val intent = Intent(holder.itemView.context,AyatActivity::class.java)
                intent.putExtra("nomor_surah",mListSurah[position].nomorSurah)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return mListSurah.size
    }

    class ItemViewHolder(val binding: ItemListSurahBinding):RecyclerView.ViewHolder(binding.root)
}