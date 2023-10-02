package com.yusril.myquran.domain.datasource

import com.yusril.myquran.data.mapper.SurahMapperEntity
import com.yusril.myquran.data.network.ApiServices
import com.yusril.myquran.data.response.SurahModel
import com.yusril.myquran.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val apiServices: ApiServices,
    private val localDataSource: LocalDataSource
) {
    suspend fun getListSurah() : List<SurahModel> {
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