package com.yusril.myquran.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yusril.myquran.data.local.entity.SurahEntity
import com.yusril.myquran.data.response.SurahResponse

@Dao
interface SurahDao {
    @Query("SELECT * from surah")
    fun getAllSurah(): List<SurahEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(data:  List<SurahEntity>)
}