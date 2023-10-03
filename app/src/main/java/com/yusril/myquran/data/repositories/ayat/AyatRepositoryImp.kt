package com.yusril.myquran.data.repositories.ayat

import com.yusril.myquran.data.local.entity.AyatEntity
import com.yusril.myquran.data.response.AyatModel
import com.yusril.myquran.data.datasource.LocalDataSource
import com.yusril.myquran.data.datasource.RemoteDataSource
import com.yusril.myquran.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AyatRepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : AyatRepository {
    override suspend fun getAyat(nomorAyat: String): Flow<Resource<List<AyatModel>>> {
        return remoteDataSource.getListAyat(nomorAyat).flowOn(Dispatchers.IO)
    }

    override suspend fun setAyatBookmarked(ayat: AyatEntity, bookmarkState: Boolean) {
        ayat.isBookmarked = bookmarkState
//        localDataSource.setAyatBookmarked(ayat,bookmarkState)
    }

}