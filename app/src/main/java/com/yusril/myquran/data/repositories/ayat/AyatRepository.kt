package com.yusril.myquran.data.repositories.ayat

import com.yusril.myquran.data.local.entity.AyatEntity
import com.yusril.myquran.data.local.room.AyatDao
import com.yusril.myquran.data.response.AyatModel
import com.yusril.myquran.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AyatRepository {
    suspend fun getAyat(nomorAyat:String): Flow<Resource<List<AyatModel>>>

    suspend fun setAyatBookmarked(ayat : AyatEntity, bookmarkState : Boolean)

}