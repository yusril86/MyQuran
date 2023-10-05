package com.yusril.myquran.data.datasource

import com.yusril.myquran.data.local.entity.SurahEntity
import com.yusril.myquran.data.local.room.AyatDao
import com.yusril.myquran.data.local.room.SurahDao
import com.yusril.myquran.data.response.SurahResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val ayatDao: AyatDao,
    private val surahDao: SurahDao
) {
    fun getSurahDataLocal(): List<SurahEntity>{
        return surahDao.getAllSurah()
    }

    suspend fun insertData(dataEntity:  List<SurahEntity>) {
        surahDao.insertAll(dataEntity)
    }
}