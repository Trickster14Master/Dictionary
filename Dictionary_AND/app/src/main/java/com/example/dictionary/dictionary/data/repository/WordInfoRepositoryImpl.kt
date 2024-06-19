package com.example.dictionary.dictionary.data.repository

import com.example.dictionary.core.util.Resource
import com.example.dictionary.dictionary.data.local.WordInfoDao
import com.example.dictionary.dictionary.data.remote.DictionaryApi
import com.example.dictionary.dictionary.domain.model.WordModel
import com.example.dictionary.dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api:DictionaryApi,
    private val dao:WordInfoDao
):WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordModel>>> = flow {
        // засовываем в поток информацию о том что началась загрузка
        emit(Resource.Loading())

        // получаем значение из локальной базы данных
        val wordInfos=dao.getWordInfos(word).map { it.toWordModel() }
        // опять показываем что идёт загрузка
        emit(Resource.Loading(data = wordInfos))

        // открываем попытку обратиться к API
        try {
            // обращаемся к API  получаем искомое слово
            val remoteWordInfo = api.getWordInfo(word)
            // удаляем прежнее значение
            dao.deleteWordInfos(remoteWordInfo.map { it.Word })
            // вставляем новые данные которые пришли из API
            dao.insertWordInfos(remoteWordInfo.map { it.toWordInfoEntity() })
        // обрабатываем ошибки
        }catch (e:HttpException){
            emit(Resource.Error(message = "Что то пошло по пизде", data = wordInfos))
        }catch (e:IOException){
            emit(Resource.Error(message = "Что то с инетом", data = wordInfos))
        }

        // получаем итоговое значение
        val newWordInfos = dao.getWordInfos(word).map { it.toWordModel() }
        // возвращаем итоговое значение в поток
        emit(Resource.Success(newWordInfos))
    }
}