package com.yusril.myquran.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yusril.myquran.data.response.AyatModel
import com.yusril.myquran.databinding.ItemListAyatBinding

class AyatAdapter( private val list: List<AyatModel>) :
    RecyclerView.Adapter<AyatAdapter.ViewHolder>() {

    var onItemClick : ((AyatModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemListAyatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            list[position].apply {
                tvAyat.text = nomorAyat
                tvArti.text = artiAyat
                tvArabicSurah.text = arabAyat
            }
            holder.itemView.setOnClickListener {
                onItemClick?.invoke(list[position])
            }
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(val binding: ItemListAyatBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}