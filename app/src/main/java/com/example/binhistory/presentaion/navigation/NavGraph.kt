package com.example.binhistory.presentaion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.binhistory.presentaion.cardInfo.CardInfoScreen
import com.example.binhistory.presentaion.cardHistory.CardHistoryScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "card_info") {
        composable("card_info") {
            CardInfoScreen()
        }
        composable("card_history") {
            CardHistoryScreen()
        }
    }
}