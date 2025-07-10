package com.example.binhistory.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.binhistory.presentation.cardInfo.CardInfoScreen
import com.example.binhistory.presentation.cardHistory.CardHistoryScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "card_info") {
        composable("card_info") {
            CardInfoScreen(navController = navController)
        }
        composable("card_history") {
            CardHistoryScreen()
        }
    }
}