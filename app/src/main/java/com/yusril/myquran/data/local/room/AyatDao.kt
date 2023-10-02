package com.yusril.myquran.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.yusril.myquran.data.local.entity.AyatEntity
import com.yusril.myquran.data.local.entity.SurahEntity
import javax.inject.Singleton

@Dao
interface AyatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAyat(ayat : List<AyatEntity>)

    @Query("SELECT * from ayat")
     fun getAllAyat(): LiveData<List<AyatEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun bookmarkedAyat(ayat : AyatEntity):Long

    @Update
    suspend fun updateAyat(ayat : AyatEntity)

    @Query("DELETE FROM ayat where bookmarked = 0")
    suspend fun deleteAllAyat()

    @Query("SELECT EXISTS(SELECT * FROM ayat WHERE nomor = :nomor AND bookmarked = 1)")
    suspend fun isAyatBookmarked(nomor: String): Boolean
}