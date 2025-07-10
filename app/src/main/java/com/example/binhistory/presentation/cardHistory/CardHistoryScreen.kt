package com.example.binhistory.presentation.cardHistory

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.binhistory.presentation.components.InfoRow
import com.example.binhistory.ui.theme.BINHistoryTheme

@Composable
fun CardHistoryScreen(viewModel: CardHistoryViewModel = hiltViewModel()) {
    val state by viewModel.state

    BINHistoryTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "История запросов",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                if (state.cards.isEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "История запросов пуста",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(state.cards, key = { it.bin }) { card ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(12.dp),
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp),
                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Text(
                                        text = "BIN: ${card.bin}",
                                        style = MaterialTheme.typography.titleMedium,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    InfoRow(
                                        label = "Схема",
                                        value = card.scheme ?: "Не указано"
                                    )
                                    InfoRow(
                                        label = "Тип",
                                        value = card.type ?: "Не указано"
                                    )
                                    InfoRow(
                                        label = "Бренд",
                                        value = card.brand ?: "Не указано"
                                    )
                                    InfoRow(
                                        label = "Страна",
                                        value = card.countryName ?: "Не указано"
                                    )
                                    card.bankName?.let {
                                        InfoRow(
                                            label = "Банк",
                                            value = it
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}