package com.yusril.myquran.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ayat")
data class AyatEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "nomor")
    val nomorAyat :String,

    @ColumnInfo(name = "ar")
    val arabAyat:String,

    @ColumnInfo(name = "idn")
    val artiAyat:String,

    @ColumnInfo(name = "tr")
    val transliterasi:String,

    @ColumnInfo(name = "bookmarked")
    var isBookmarked: Boolean

)