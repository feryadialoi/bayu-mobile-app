package dev.feryadi.bayu

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.feryadi.bayu.screen.HomeScreen
import dev.feryadi.bayu.screen.login.LoginScreen
import dev.feryadi.bayu.screen.profile.ProfileScreen
import dev.feryadi.bayu.screen.splash.SplashScreen


object Routes {
    const val SPLASH = "splash"
    const val LOGIN = "login"
    const val HOME = "home"
    const val PROFILE = "profile"
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppRouter() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SPLASH) {
        composable(Routes.SPLASH) { SplashScreen(navController) }
        composable(Routes.LOGIN) { LoginScreen(navController) }
        composable(Routes.HOME) { HomeScreen(navController) }
        composable(Routes.PROFILE) { ProfileScreen(navController) }
    }

}