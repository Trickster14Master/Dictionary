package com.example.dictionary.core.util

// создаём псевдоним
typealias SimpleResource = Resource<Unit>

// класс который определяет на какой стадии находятся данные, и в зависимости от того на какой они стадии выдаёт разные результаты
sealed class Resource<T>(val data:T?=null, val message:String?=null) {
    class Loading<T>(data: T?=null):Resource<T>(data)
    class Success<T>(data: T?):Resource<T>(data)
    class Error<T>(message: String?,data: T?=null):Resource<T>(data,message)
}