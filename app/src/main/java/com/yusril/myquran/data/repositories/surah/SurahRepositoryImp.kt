package com.yusril.myquran.data.repositories.surah

import com.yusril.myquran.data.local.entity.SurahEntity
import com.yusril.myquran.data.mapper.SurahMapperEntity
import com.yusril.myquran.data.response.SurahModel
import com.yusril.myquran.domain.datasource.LocalDataSource
import com.yusril.myquran.domain.datasource.RemoteDataSource
import com.yusril.myquran.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SurahRepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : SurahRepository {
    override suspend fun getSurah(): Flow<Resource<List<SurahModel>>> = flow {
//        emit(Resource.Loading) // Emit status loading

        // Coba ambil data dari lokal
        val localSurahs = localDataSource.getAllData()
        emit(Resource.Success(localSurahs))

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

    /*private suspend fun refreshDataFromServer() {
        remoteDataSource.getListSurah().collect { result ->
            if (result is Resource.Success) {
                result.data?.let { dataResponse ->
                    val dataEntities = convertResponseToEntities(dataResponse)
                    dataEntities.forEach { _ ->
                        localDataSource.insertData(dataEntities)
                    }
                }
            } else if (result is Resource.Error) {
                // Handle error
            }
        }
    }*/

    /*private fun convertResponseToEntities(response: List<SurahModel>): List<SurahEntity> {
        val dataEntities = mutableListOf<SurahEntity>()

        for (dataItem in response) {
            val dataEntity = SurahEntity(
                id = 1,
                nomorSurah = dataItem.nomorSurah.toString(),
                namaSurah = dataItem.namaSurah.toString(),
                asma = dataItem.asma.toString(),
                daerahType = dataItem.daerahType.toString(),
                jumlahAyat = dataItem.jumlahAyat.toString(),
                keteranganSurah = dataItem.keteranganSurah.toString()
                // Set other fields as needed
            )
            dataEntities.add(dataEntity)
        }

        return dataEntities
    }*/

   /* private fun getData() {
       return remoteDataSource.getListSurah()
            .flatMapConcat { result ->
                when (result) {
                    is Resource.Success -> {
                        localDataSource.insertData(SurahMapperEntity(result.data!!))
                        flowOf(result)
                    }
                    is Resource.Error -> {
                        val cachedMovies = localDataSource.getAllData()
                        *//*if (cachedMovies.isNotEmpty()) {
                            flowOf(Resource.Success(result.data(cachedMovies)))
                        } else {
                            flowOf(result)
                        }*//*
                        flowOf(result)
                    }
                    is Resource.Loading -> flowOf(result)
                }
            }
    }*/

}

