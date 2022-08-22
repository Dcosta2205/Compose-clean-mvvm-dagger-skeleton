package com.ssup.composeandcleanarchitecture.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ssup.composeandcleanarchitecture.Destination
import com.ssup.composeandcleanarchitecture.presentation.data.DataScreen
import com.ssup.composeandcleanarchitecture.presentation.main.MainViewModel
import com.ssup.composeandcleanarchitecture.ui.theme.ComposeAndCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ComposeAndCleanArchitectureTheme {
                NavHost(navController = navController, startDestination = Destination.MAIN.route) {
                    composable(route = Destination.MAIN.route) {
                        MainScreen(navController = navController)
                    }
                    composable(route = Destination.Data.route) {
                        DataScreen(mainViewModel = mainViewModel)
                    }
                }
            }
        }
    }
}
