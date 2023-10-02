package com.yusril.myquran.di

import android.content.Context
import com.yusril.myquran.data.local.room.AyatDao
import com.yusril.myquran.data.local.room.QuranDatabase
import com.yusril.myquran.data.local.room.SurahDao
import com.yusril.myquran.data.network.ApiServices
import com.yusril.myquran.data.repositories.ayat.AyatRepository
import com.yusril.myquran.data.repositories.ayat.AyatRepositoryImp
import com.yusril.myquran.data.repositories.surah.SurahRepository
import com.yusril.myquran.data.repositories.surah.SurahRepositoryImp
import com.yusril.myquran.domain.datasource.LocalDataSource
import com.yusril.myquran.domain.datasource.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): ApiServices {
        return retrofit.create(ApiServices::class.java)
    }


    @Provides
    fun provideSurahRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): SurahRepository {
        return SurahRepositoryImp(remoteDataSource, localDataSource)
    }

    @Provides
    fun provideAyatRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): AyatRepository {
        return AyatRepositoryImp(remoteDataSource, localDataSource)
    }

    @Provides
    fun providesAyatDao(quranDatabase: QuranDatabase): AyatDao {
        return quranDatabase.ayatDao()
    }
    @Provides
    fun providesSurahDao(quranDatabase: QuranDatabase): SurahDao {
        return quranDatabase.surahDao()
    }

    @Provides
    fun provideQuranDatabase(@ApplicationContext appContext: Context): QuranDatabase =
        QuranDatabase.getInstance(appContext)
}