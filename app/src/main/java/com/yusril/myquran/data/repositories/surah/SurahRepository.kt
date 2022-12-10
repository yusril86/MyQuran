package com.yusril.myquran.data.repositories.surah

import com.yusril.myquran.data.response.SurahModel
import com.yusril.myquran.utils.Resource
import kotlinx.coroutines.flow.Flow

interface SurahRepository {
     suspend fun getSurah(): Flow<Resource<List<SurahModel>>>
}