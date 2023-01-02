package com.yusril.myquran.data.response

import com.google.gson.annotations.SerializedName

data class AyatModel(
    @SerializedName("ar")
    val arabAyat:String,

    @SerializedName("id")
    val artiAyat:String,

    @SerializedName("tr")
    val transliterasi:String,

    @SerializedName("nomor")
    val nomorAyat :String

)


