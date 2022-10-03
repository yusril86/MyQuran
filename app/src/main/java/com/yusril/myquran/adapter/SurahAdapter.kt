package com.yusril.myquran.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yusril.myquran.data.response.SurahModel
import com.yusril.myquran.databinding.ItemListSurahBinding

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
        }
    }

    override fun getItemCount(): Int {
        return mListSurah.size
    }

    class ItemViewHolder(val binding: ItemListSurahBinding):RecyclerView.ViewHolder(binding.root)
}