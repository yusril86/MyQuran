package com.yusril.myquran.data.response

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
//@Entity(tableName = "surah")
data class SurahResponse(
//    @PrimaryKey(autoGenerate = true)
    val id : Int,

    @SerializedName("nama")
    val namaSurah: String? = null,

    @SerializedName("asma")
    val asma : String? = null,

    @SerializedName("type")
    val daerahType: String? = null,

    @SerializedName("ayat")
    val jumlahAyat: String? = null,

    @SerializedName("nomor")
    val nomorSurah: String? = null,

    @SerializedName("keterangan")
    val keteranganSurah : String? = null

):Parcelable
