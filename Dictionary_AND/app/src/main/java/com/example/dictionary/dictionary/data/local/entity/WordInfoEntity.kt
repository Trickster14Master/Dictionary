package com.example.dictionary.dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionary.dictionary.domain.model.ExampleModel
import com.example.dictionary.dictionary.domain.model.WordModel

@Entity
// модель для локальной БД
data class WordInfoEntity(
    @PrimaryKey val id:Int?=null,
    val Word:String,
    val Translation:String,
    val Example:List<ExampleModel>
){
    fun toWordModel(): WordModel{
        return WordModel(
            id=id!!,
            Word=Word,
            Translation=Translation,
            Example=Example
        )
    }

}