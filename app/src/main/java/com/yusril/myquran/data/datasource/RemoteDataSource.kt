package com.yusril.myquran.data.datasource

import com.yusril.myquran.data.network.ApiServices
import com.yusril.myquran.data.response.SurahResponse
import com.yusril.myquran.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val apiServices: ApiServices,
    private val localDataSource: LocalDataSource
) {
    suspend fun getListSurah() : List<SurahResponse> {
        return apiServices.getListSurah()
    }

    suspend fun getListAyat(ayat:String) = flow {
        emit(Resource.Loading())
        try {
            val response = apiServices.getAyat(ayat)
            emit(Resource.Success(data = response))
        } catch (exception: Exception) {
            emit(Resource.Error(exception.toString()))
        }
    }

}