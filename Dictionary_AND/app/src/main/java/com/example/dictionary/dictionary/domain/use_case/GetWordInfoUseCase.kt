package com.example.dictionary.dictionary.domain.use_case

import com.example.dictionary.core.util.Resource
import com.example.dictionary.dictionary.domain.model.WordModel
import com.example.dictionary.dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfoUseCase(
    private val repository: WordInfoRepository
) {

    operator fun invoke(word:String): Flow<Resource<List<WordModel>>>{
        if(word.isBlank()){
            return flow{}
        }
        return repository.getWordInfo(word)
    }
}