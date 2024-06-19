package com.example.dictionary.dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dictionary.dictionary.data.util.JsonParser
import com.example.dictionary.dictionary.domain.model.ExampleModel
import com.example.dictionary.dictionary.domain.model.WordModel
import com.google.gson.reflect.TypeToken

// функции которые будут конвертировать данные для локальной базы данных
@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromWordsJson(json:String):List<ExampleModel>{
        return jsonParser.fromJson<ArrayList<ExampleModel>>(
            json,
            object :TypeToken<ArrayList<ExampleModel>>(){}.type
        )?: emptyList()
    }

    @TypeConverter
    fun toWordsJson(word:List<ExampleModel>):String{
        return jsonParser.toJson(
            word,
            object :TypeToken<ArrayList<ExampleModel>>(){}.type
        )?:"[]"
    }
}