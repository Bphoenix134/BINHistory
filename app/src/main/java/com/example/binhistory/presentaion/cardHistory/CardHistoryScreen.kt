package com.example.binhistory.presentaion.cardHistory

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CardHistoryScreen(viewModel: CardHistoryViewModel = hiltViewModel()) {
    val state by viewModel.state
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(state.cards) { card ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("BIN: ${card.bin}")
                    Text("Схема: ${card.scheme ?: "Не указано"}")
                    Text("Тип: ${card.type ?: "Не указано"}")
                    Text("Страна: ${card.countryName ?: "Не указано"}")
                }
            }
        }
    }
}