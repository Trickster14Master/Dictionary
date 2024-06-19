package com.example.dictionary.dictionary.presentation.wordScreen

import com.example.dictionary.dictionary.domain.model.WordModel

data class WordInfoState(
    val wordInfoItem:List<WordModel> = emptyList(),
    val isLoading: Boolean=false
)
