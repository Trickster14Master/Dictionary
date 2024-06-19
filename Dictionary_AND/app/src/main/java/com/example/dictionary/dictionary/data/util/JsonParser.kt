package com.example.dictionary.dictionary.data.util

import java.lang.reflect.Type

// данный интерфейс нужен для того чтобы трансформировать список в json строку
interface JsonParser {

    fun <T> fromJson(json: String, type: Type): T?

    fun <T> toJson(obj: T, type: Type): String?
}