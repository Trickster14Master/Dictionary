package com.example.dictionary.dictionary.presentation.wordScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dictionary.dictionary.domain.model.WordModel

@Composable
fun WordInfoItem(item:WordModel) {
    Column {
        Text(text = item.Word, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Text(text = item.Translation, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Spacer(modifier = Modifier.padding(16.dp))
        
        item.Example.forEach{e->
            Text(text = e.ExampleOriginal)
            Text(text = e.ExampleTranslated)
        }
    }
}