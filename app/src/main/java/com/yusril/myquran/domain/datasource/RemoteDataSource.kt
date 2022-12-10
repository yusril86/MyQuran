package com.yusril.myquran.domain.datasource

import com.yusril.myquran.data.network.ApiServices
import com.yusril.myquran.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val apiServices: ApiServices
) {
    suspend fun getListSurah() = flow {
        emit(Resource.Loading())
        try {
            val response = apiServices.getListSurah()
            emit(Resource.Success(data = response))
        } catch (exception: Exception) {
            emit(Resource.Error(exception.toString()))
        }
    }

}