package com.yusril.myquran.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yusril.myquran.data.response.SurahModel

@Dao
interface SurahDao {
    @Query("SELECT * from surah")
    fun getAllSurah(): List<SurahModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(data:  List<SurahModel>)
}