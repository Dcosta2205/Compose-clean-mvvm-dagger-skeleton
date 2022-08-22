package com.ssup.composeandcleanarchitecture.presentation

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ssup.composeandcleanarchitecture.Destination

@Composable
fun MainScreen(navController: NavController) {
    Button(onClick = { navController.navigate(Destination.Data.route) }) {
        Text(text = "Login")
    }
}