package com.yusril.myquran.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yusril.myquran.data.local.entity.AyatEntity
import com.yusril.myquran.data.response.SurahResponse

@Database(entities = [AyatEntity::class, SurahResponse::class], version = 2)
abstract class QuranDatabase :RoomDatabase() {

    abstract fun ayatDao(): AyatDao
    abstract fun surahDao(): SurahDao

    companion object {

        private const val DB_NAME = "quran-db"

        // For Singleton instantiation
        @Volatile
        private var instance: QuranDatabase? = null

        fun getInstance(context: Context): QuranDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): QuranDatabase {
            return Room.databaseBuilder(
                context,
                QuranDatabase::class.java, DB_NAME
            ).build()
        }
    }

}