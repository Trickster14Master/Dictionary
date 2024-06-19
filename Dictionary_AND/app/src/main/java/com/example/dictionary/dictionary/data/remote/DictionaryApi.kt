package com.example.dictionary.dictionary.data.remote

import com.example.dictionary.dictionary.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DictionaryApi {

    @GET("/DictionaryAPI/DictionaryAPI/")
    suspend fun getWordInfo(@Query("search") word:String):List<WordInfoDto>

    companion object{
        const val url:String="http://192.168.0.124:8000/"
    }
}