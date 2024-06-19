package com.example.dictionary.dictionary.presentation.wordScreen

sealed class WordEvent {
    data class ShowSnacbar(val message:String):WordEvent()
}