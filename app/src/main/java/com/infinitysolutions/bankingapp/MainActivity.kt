package com.infinitysolutions.bankingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.infinitysolutions.bankingapp.ui.components.BottomNavigationBar
import com.infinitysolutions.bankingapp.ui.sections.CardsSection
import com.infinitysolutions.bankingapp.ui.sections.CurrenciesSection
import com.infinitysolutions.bankingapp.ui.sections.FinanceSection
import com.infinitysolutions.bankingapp.ui.sections.WalletSection
import com.infinitysolutions.bankingapp.ui.theme.BankingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankingAppTheme {
                SetBarColor(color = MaterialTheme.colorScheme.background)
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background){
                    HomeScreen()
            }
        }
    }
}

@Composable
private fun SetBarColor(color: androidx.compose.ui.graphics.Color){
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = color
        )
        }
    }

@Preview
@Composable
fun HomeScreen(){
    Scaffold(bottomBar = {
        BottomNavigationBar()
    }) { padding ->
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(padding)){
            WalletSection()
            CardsSection()
            FinanceSection()
            Spacer(modifier = Modifier.height(16.dp))
            CurrenciesSection()
        }

    }
}
}