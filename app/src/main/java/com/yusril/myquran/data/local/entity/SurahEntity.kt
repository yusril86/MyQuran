package com.yusril.myquran.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "surah")
data class SurahEntity(

    @field:ColumnInfo(name ="nama")
    val namaSurah: String,

    @field:ColumnInfo(name ="asma")
    val asma : String,

    @field:ColumnInfo(name ="type")
    val daerahType: String,

    @field:ColumnInfo(name ="ayat")
    val jumlahAyat: String,

    @field:ColumnInfo(name = "nomor")
    val nomorSurah: String,

    @field:ColumnInfo(name ="keterangan")
    val keteranganSurah : String
)