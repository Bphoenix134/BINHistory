package com.example.binhistory.presentation.cardInfo

import android.content.Context
import android.content.Intent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import com.example.binhistory.presentation.components.InfoRow
import com.example.binhistory.ui.theme.BINHistoryTheme

@Composable
fun CardInfoScreen(
    viewModel: CardInfoViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val state by viewModel.state
    val context = LocalContext.current
    var bin by remember { mutableStateOf("") }

    BINHistoryTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Поиск информации о карте",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = bin,
                    onValueChange = { bin = it },
                    label = { Text("Введите BIN (6–8 цифр)") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(12.dp)),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    },
                    isError = state.error != null,
                    supportingText = {
                        if (state.error != null) {
                            Text(
                                text = state.error!!,
                                color = MaterialTheme.colorScheme.error,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { viewModel.onBinEntered(bin) },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp),
                        enabled = bin.length in 6..8 && bin.all { it.isDigit() }
                    ) {
                        Text("Поиск", style = MaterialTheme.typography.labelLarge)
                    }
                    OutlinedButton(
                        onClick = { navController.navigate("card_history") },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("История", style = MaterialTheme.typography.labelLarge)
                    }
                }

                state.cardInfo?.let { card ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .animateContentSize(
                                animationSpec = spring(
                                    dampingRatio = Spring.DampingRatioLowBouncy,
                                    stiffness = Spring.StiffnessLow
                                )
                            ),
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            InfoRow(
                                label = "BIN",
                                value = card.bin
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
                            if (card.latitude != null && card.longitude != null) {
                                InfoRow(
                                    label = "Координаты",
                                    value = "${card.latitude}, ${card.longitude}",
                                    onClick = { openGeoLocation(context, card.latitude!!, card.longitude!!) },
                                    textColor = MaterialTheme.colorScheme.primary
                                )
                            }
                            InfoRow(
                                label = "Банк",
                                value = card.bankName ?: "Не указано"
                            )
                            card.bankUrl?.let { url ->
                                InfoRow(
                                    label = "Сайт банка",
                                    value = url,
                                    onClick = { openUrl(context, url) },
                                    textColor = MaterialTheme.colorScheme.primary
                                )
                            }
                            card.bankPhone?.let { phone ->
                                InfoRow(
                                    label = "Телефон банка",
                                    value = phone,
                                    onClick = { openPhone(context, phone) },
                                    textColor = MaterialTheme.colorScheme.primary
                                )
                            }
                            card.bankCity?.let { city ->
                                InfoRow(
                                    label = "Город банка",
                                    value = city
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun openUrl(context: Context, url: String) {
    val formattedUrl = if (url.startsWith("http://") || url.startsWith("https://")) url else "https://$url"
    val intent = Intent(Intent.ACTION_VIEW, formattedUrl.toUri())
    context.startActivity(intent)
}

private fun openPhone(context: Context, phone: String) {
    val intent = Intent(Intent.ACTION_DIAL, "tel:$phone".toUri())
    context.startActivity(intent)
}

private fun openGeoLocation(context: Context, latitude: Double, longitude: Double) {
    val intent = Intent(Intent.ACTION_VIEW, "geo:$latitude,$longitude".toUri())
    context.startActivity(intent)
}