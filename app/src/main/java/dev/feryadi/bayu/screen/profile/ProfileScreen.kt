package dev.feryadi.bayu.screen.profile

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Preview(showBackground = true)
@Composable
fun ProfileScreen(
    navController: NavController = NavController(LocalContext.current)
) {
    Scaffold {
        Text(text = "profile")
    }
}