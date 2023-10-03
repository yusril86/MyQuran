package com.yusril.myquran.data.repositories.surah

import com.yusril.myquran.data.response.SurahResponse
import com.yusril.myquran.data.datasource.LocalDataSource
import com.yusril.myquran.data.datasource.RemoteDataSource
import com.yusril.myquran.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SurahRepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : SurahRepository {
    override suspend fun getSurah(): Flow<Resource<List<SurahResponse>>> = flow {
        emit(Resource.Loading()) // Emit status loading

        // Coba ambil data dari lokal
        val localSurahs = localDataSource.getSurahDataLocal()
        if (localSurahs.isNotEmpty()){
            emit(Resource.Success(localSurahs))
        }

        // Ambil data dari remote
        try {
            val remoteSurahs = remoteDataSource.getListSurah()
            localDataSource.insertData(remoteSurahs)
            emit(Resource.Success(remoteSurahs))
        } catch (e: Exception) {
            // Emit error jika gagal mengambil data dari remote
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)


}

