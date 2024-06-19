package com.example.dictionary.dictionary.data.remote.dto

import com.example.dictionary.dictionary.domain.model.ExampleModel

data class ExampleDto(
    val id:Int,
    val ExampleOriginal:String,
    val ExampleTranslated:String
){
    fun toExampleModel():ExampleModel{
        return ExampleModel(
            id=id,
            ExampleOriginal=ExampleOriginal,
            ExampleTranslated=ExampleTranslated
        )
    }
}