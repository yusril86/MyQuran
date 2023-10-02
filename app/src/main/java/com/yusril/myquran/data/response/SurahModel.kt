package com.yusril.myquran.data.response

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "surah")
data class SurahModel(
    @SerializedName("nama")
    @PrimaryKey
    @field:ColumnInfo(name ="nama")
    val namaSurah: String,

    @SerializedName("asma")
    @field:ColumnInfo(name ="asma")
    val asma : String? = null,

    @SerializedName("type")
    @field:ColumnInfo(name ="type")
    val daerahType: String? = null,

    @SerializedName("ayat")
    @field:ColumnInfo(name ="ayat")
    val jumlahAyat: String? = null,

    @SerializedName("nomor")
    @field:ColumnInfo(name = "nomor")
    val nomorSurah: String? = null,

    @SerializedName("keterangan")
    @field:ColumnInfo(name = "keterangan")
    val keteranganSurah : String? = null

):Parcelable
