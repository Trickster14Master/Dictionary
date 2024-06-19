package com.example.dictionary.dictionary.presentation.wordScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WordScreen() {
    val viewModel:WordInfoViewModel= hiltViewModel()

    val state = viewModel.state.value
    val scaffoldState = SnackbarHostState()

    LaunchedEffect(key1 = true){
        viewModel.eventFlow.collectLatest { event->
            when(event){
                is WordEvent.ShowSnacbar -> {
                    scaffoldState.showSnackbar(message = event.message)
                }
            }
        }
    }

    Scaffold() {paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)){
            Column(modifier= Modifier
                .fillMaxSize()
                .padding(10.dp)) {
                TextField(
                    viewModel.searchQuery.value,
                    viewModel::onSearch,
                    Modifier.fillMaxWidth(),
                    placeholder = {Text(text="search....")})
                Spacer(modifier = Modifier.padding(10.dp))
                LazyColumn(modifier= Modifier.fillMaxSize()){
                    items(state.wordInfoItem.size){i->
                        val wordInfo = state.wordInfoItem[i]
                        
                        if(i>0){
                            Spacer(modifier = Modifier.padding(8.dp))
                        }
                        WordInfoItem(item=wordInfo)
                    }
                }
            }
        }
    }
}