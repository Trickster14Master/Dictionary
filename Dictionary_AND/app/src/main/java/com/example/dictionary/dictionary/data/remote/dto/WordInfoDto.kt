package com.example.dictionary.dictionary.data.remote.dto

import com.example.dictionary.dictionary.data.local.entity.WordInfoEntity
import com.example.dictionary.dictionary.domain.model.WordModel

// первичный класс который будет использоваться для получения данных с API
data class WordInfoDto(
    val id:Int,
    val Word:String,
    val Translation:String,
    val Dictionary_Example:List<ExampleDto>
){
    // функция которая сопостовляет модель  на ля удалённой базы данных
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            id=id,
            Word=Word,
            Translation=Translation,
            Example = Dictionary_Example.map { it.toExampleModel() },
        )
    }
}