package com.yusril.myquran.data.response

import com.google.gson.annotations.SerializedName

data class AyatModel(
    @SerializedName("ar")
    val arabAyat:String,

    @SerializedName("id")
    val idAyat:String,

    @SerializedName("tr")
    val transliterasi:String,

    @SerializedName("nomor")
    val nomor :String

)


