package com.example.dictionary.dictionary.domain.repository

import com.example.dictionary.core.util.Resource
import com.example.dictionary.dictionary.domain.model.WordModel
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    fun getWordInfo(word:String): Flow<Resource<List<WordModel>>>
}