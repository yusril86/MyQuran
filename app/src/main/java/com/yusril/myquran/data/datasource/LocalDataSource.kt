package com.yusril.myquran.data.datasource

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
    fun getSurahDataLocal(): List<SurahResponse>{
        return surahDao.getAllSurah()
    }

    suspend fun insertData(dataEntity:  List<SurahResponse>) {
        surahDao.insertAll(dataEntity)
    }
}