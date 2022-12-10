package com.yusril.myquran.data.repositories.surah

import com.yusril.myquran.data.response.SurahModel
import com.yusril.myquran.domain.datasource.RemoteDataSource
import com.yusril.myquran.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SurahRepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
): SurahRepository {
    override suspend fun getSurah(): Flow<Resource<List<SurahModel>>> =
        remoteDataSource.getListSurah().flowOn(Dispatchers.IO)

}
