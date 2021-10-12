package dev.feryadi.bayu.screen.splash


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.feryadi.bayu.Routes
import dev.feryadi.bayu.ui.theme.BlueSea
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun SplashScreen(
    navController: NavController = NavController(LocalContext.current)
) {

    LaunchedEffect(true) {
        delay(2000)
        navController.navigate(Routes.LOGIN)
    }

    Scaffold {
        Column(
            modifier = Modifier
                .background(BlueSea)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "BAYU", style = TextStyle(color = Color.White, fontSize = 32.sp))
        }
    }
}