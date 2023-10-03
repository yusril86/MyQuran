package com.yusril.myquran.data.network

import com.yusril.myquran.data.response.AyatModel
import com.yusril.myquran.data.response.SurahResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {

    @GET("/99c279bb173a6e28359c/data")
    suspend fun getListSurah(): List<SurahResponse>

    @GET("/99c279bb173a6e28359c/surat/{ayat}")
    suspend fun getAyat(
        @Path("ayat") numberAyat:String
    ):List<AyatModel>
}