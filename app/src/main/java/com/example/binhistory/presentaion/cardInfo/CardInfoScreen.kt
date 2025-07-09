package com.example.binhistory.presentaion.cardInfo

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.core.net.toUri

@Composable
fun CardInfoScreen(viewModel: CardInfoViewModel = hiltViewModel()) {
    val state by viewModel.state
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var bin by remember { mutableStateOf("") }
        TextField(
            value = bin,
            onValueChange = { bin = it },
            label = { Text("Введите BIN") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { viewModel.onBinEntered(bin) }) {
            Text("Поиск")
        }
        Spacer(modifier = Modifier.height(16.dp))

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(alignment = androidx.compose.ui.Alignment.CenterHorizontally))
        }
        state.cardInfo?.let { card ->
            Text("Схема: ${card.scheme ?: "Не указано"}")
            Text("Тип: ${card.type ?: "Не указано"}")
            Text("Бренд: ${card.brand ?: "Не указано"}")
            Text("Страна: ${card.countryName ?: "Не указано"}")
            if (card.latitude != null && card.longitude != null) {
                Text(
                    text = "Координаты: ${card.latitude}, ${card.longitude}",
                    color = Color.Blue,
                    modifier = Modifier.clickable {
                        openGeoLocation(context, card.latitude, card.longitude)
                    }
                )
            }
            Text("Банк: ${card.bankName ?: "Не указано"}")
            card.bankUrl?.let { url ->
                Text(
                    text = url,
                    color = Color.Blue,
                    modifier = Modifier.clickable {
                        openUrl(context, url)
                    }
                )
            }
            card.bankPhone?.let { phone ->
                Text(
                    text = phone,
                    color = Color.Blue,
                    modifier = Modifier.clickable {
                        openPhone(context, phone)
                    }
                )
            }
        }
        state.error?.let { error ->
            Text(
                text = "Ошибка: $error",
                color = Color.Red,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

private fun openUrl(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, url.toUri())
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