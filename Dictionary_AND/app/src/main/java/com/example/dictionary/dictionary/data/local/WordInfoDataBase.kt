package com.example.dictionary.dictionary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.dictionary.dictionary.data.local.entity.WordInfoEntity

@Database(
    entities = [WordInfoEntity::class],
    version = 1
)
// прикрепляем клас для конвертации
@TypeConverters(Converters::class)
abstract class WordInfoDataBase:RoomDatabase() {

    abstract val dao:WordInfoDao


}