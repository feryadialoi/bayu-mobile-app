package dev.feryadi.bayu.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.feryadi.bayu.model.Transaction
import dev.feryadi.bayu.ui.theme.BlueSea
import java.math.BigDecimal
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun HomeScreen(
    navController: NavController = NavController(LocalContext.current)
) {


    Scaffold {

        Column {
            Hero()
            HomeContent()

        }
    }
}

@Composable
fun Hero() {
    Column(
        modifier = Modifier
            .background(BlueSea)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "My Balance")
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Rounded.Home, contentDescription = "")
            }
        }

        Text(text = "$320,064")

        Text(text = "Monday, Oct 11 2021")

    }
}

@Composable
fun SpentIncome() {
    Card {
        Row {
            Column {
                Text(text = "Spent")
                Text(text = "$2,018")
            }
            Column {
                Text(text = "Income")
                Text(text = "$3,541")
            }
        }
    }
}

@Composable
fun TransactionView() {
    Card {
        Row {
            Column {
                Text(text = "11")
                Text(text = "Monday")
            }
            Row {
                Icon(Icons.Default.Info, contentDescription = "")
                Column {
                    Text(text = "Coffee")
                    Text(text = "La latte shop")
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeContent() {
    val todayTransactions = remember {
        mutableStateListOf<Transaction>(
            Transaction(
                id = "1",
                name = "Coffee", description = "Latte shop",
                date = LocalDateTime.now(),
                amount = BigDecimal(100)
            ),
            Transaction(
                id = "1",
                name = "Coffee", description = "Latte shop",
                date = LocalDateTime.now(),
                amount = BigDecimal(100)
            ),
            Transaction(
                id = "1",
                name = "Coffee", description = "Latte shop",
                date = LocalDateTime.now(),
                amount = BigDecimal(100)
            ),
        )
    }

    val yesterdayTransactions = remember {
        mutableStateListOf<Transaction>(
            Transaction(
                id = "1",
                name = "Coffee", description = "Latte shop",
                date = LocalDateTime.now(),
                amount = BigDecimal(100)
            ),
            Transaction(
                id = "1",
                name = "Coffee", description = "Latte shop",
                date = LocalDateTime.now(),
                amount = BigDecimal(100)
            ),
            Transaction(
                id = "1",
                name = "Coffee", description = "Latte shop",
                date = LocalDateTime.now(),
                amount = BigDecimal(100)
            ),
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp
            )
    ) {
        SpentIncome()

        Text(text = "Today")
        todayTransactions.forEach {
            TransactionView()
        }
        Text(text = "Yesterday")
        yesterdayTransactions.forEach {
            TransactionView()
        }
    }

}