package dev.feryadi.bayu.screen.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.feryadi.bayu.Routes

@Preview(showBackground = true)
@Composable
fun LoginScreen(
    navController: NavController = NavController(LocalContext.current)
) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val snackbarVisible = remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier.padding(16.dp)) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {

            Text(text = "Login")

            TextField(
                label = { Text(text = "Username") },
                value = username.value,
                onValueChange = { username.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
            )
            TextField(
                label = { Text(text = "Password") },
                value = password.value,
                onValueChange = { password.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Button(
                modifier = Modifier.fillMaxWidth(),
                content = { Text(text = "Login") },
                onClick = {
                    if (username.value != "" && password.value != "") {
                        navController.navigate(Routes.HOME)
                    } else {
                        snackbarVisible.value = true
                    }
                },
            )

            if (snackbarVisible.value) {
                Snackbar(
                    action = {
                        Button(onClick = {
                            snackbarVisible.value = false
                        }) {
                            Text("dismiss")
                        }
                    },
                    content = { Text(text = "Username or Password invalid") }
                )
            }
        }
    }
}