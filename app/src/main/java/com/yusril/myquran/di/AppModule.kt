package com.yusril.myquran.di

import com.yusril.myquran.data.network.ApiServices
import com.yusril.myquran.data.repositories.surah.SurahRepository
import com.yusril.myquran.data.repositories.surah.SurahRepositoryImp
import com.yusril.myquran.domain.datasource.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit):ApiServices{
        return retrofit.create(ApiServices::class.java)
    }


    @Provides
    fun provideSurahRepository(remoteDataSource: RemoteDataSource): SurahRepository {
        return SurahRepositoryImp(remoteDataSource)
    }
}