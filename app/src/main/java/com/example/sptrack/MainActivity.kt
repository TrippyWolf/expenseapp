package com.example.sptrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.sptrack.database.AppDatabase
import com.example.sptrack.ui.nav.BottomNavHostScreen
import com.example.sptrack.ui.nav.MainScreenNavigation
import com.example.sptrack.ui.theme.SPTrackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val database = AppDatabase.getDatabase(applicationContext)
            val repository = TransactionRepository(database)
            val viewModel: TransactionViewModel =
                viewModel(factory = TransactionViewModelFactory(repository))
            CompositionLocalProvider(LocalTransactionViewModel provides viewModel) {
                MainScreen()
            }

        }
    }
}

@Composable
private fun MainScreen() {
    var isLightTheme by remember { mutableStateOf(true) }

    SPTrackTheme(isLightTheme =isLightTheme) {

        BottomNavHostScreen(onThemeChange = { isLightTheme = !isLightTheme })
    }
}
