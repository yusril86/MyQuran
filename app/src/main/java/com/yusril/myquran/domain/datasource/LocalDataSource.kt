package com.yusril.myquran.domain.datasource

import androidx.lifecycle.LiveData
import com.yusril.myquran.data.local.entity.AyatEntity
import com.yusril.myquran.data.local.entity.SurahEntity
import com.yusril.myquran.data.local.room.AyatDao
import com.yusril.myquran.data.local.room.SurahDao
import com.yusril.myquran.data.response.SurahModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val ayatDao: AyatDao,
    private val surahDao: SurahDao
) {
    fun getAllData(): List<SurahModel>{
        return surahDao.getAllSurah()
    }

    suspend fun insertData(dataEntity:  List<SurahModel>) {
        surahDao.insertAll(dataEntity)
    }
}