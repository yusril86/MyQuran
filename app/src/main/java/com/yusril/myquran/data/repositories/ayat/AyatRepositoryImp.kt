package com.yusril.myquran.data.repositories.ayat

import com.yusril.myquran.data.response.AyatModel
import com.yusril.myquran.domain.datasource.RemoteDataSource
import com.yusril.myquran.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AyatRepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : AyatRepository {

    override suspend fun getAyat(nomorAyat: String): Flow<Resource<List<AyatModel>>> {
        return remoteDataSource.getListAyat(nomorAyat).flowOn(Dispatchers.IO)
    }

}