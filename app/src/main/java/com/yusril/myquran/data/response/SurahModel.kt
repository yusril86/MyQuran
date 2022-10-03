package com.yusril.myquran.data.response

import com.google.gson.annotations.SerializedName

data class SurahModel(

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

)
