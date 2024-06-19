package com.example.dictionary.dictionary.di

import android.app.Application
import androidx.room.Room
import com.example.dictionary.dictionary.data.local.Converters
import com.example.dictionary.dictionary.data.local.WordInfoDao
import com.example.dictionary.dictionary.data.local.WordInfoDataBase
import com.example.dictionary.dictionary.data.remote.DictionaryApi
import com.example.dictionary.dictionary.data.repository.WordInfoRepositoryImpl
import com.example.dictionary.dictionary.data.util.GsonParser
import com.example.dictionary.dictionary.domain.repository.WordInfoRepository
import com.example.dictionary.dictionary.domain.use_case.GetWordInfoUseCase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {
    // пишем инъекции самостоятельно вместо использования @Inject constructor
    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfoUseCase {
        return GetWordInfoUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db:WordInfoDataBase,
        api:DictionaryApi
    ):WordInfoRepository{
        return WordInfoRepositoryImpl(api, db.dao)
    }

    // создаём иньекцию ДБ
    @Provides
    @Singleton
    fun provideWordInfoDatabase(app:Application):WordInfoDataBase{
        return Room.databaseBuilder(
            app, WordInfoDataBase::class.java, "word_db"
        // через addTypeConverter пепредаём ранее созданный конвертор
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi():DictionaryApi{
        return Retrofit.Builder()
            .baseUrl(DictionaryApi.url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }
}