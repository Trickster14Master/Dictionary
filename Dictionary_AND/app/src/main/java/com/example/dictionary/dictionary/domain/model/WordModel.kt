package com.example.dictionary.dictionary.domain.model

data class WordModel(
    val id:Int,
    val Word:String,
    val Translation:String,
    val Example:List<ExampleModel>
)