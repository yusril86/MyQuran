package com.yusril.myquran.data.network

import com.yusril.myquran.data.response.BaseResponse
import com.yusril.myquran.data.response.BaseResponseList
import com.yusril.myquran.data.response.SurahModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {

    @GET("/99c279bb173a6e28359c/data")
    suspend fun getListSurah(): List<SurahModel>
}