package com.example.tugaspratikum6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugaspratikum6.ui.theme.TugasPratikum6Theme
import com.example.tugaspratikum6.view.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasPratikum6Theme {
                val navController = rememberNavController()
                val pesertaList = remember { mutableStateListOf<PesertaData>() }

                NavHost(
                    navController = navController,
                    startDestination = "welcome"
                ) {
                    composable("welcome") {
                        HalamanWelcome(
                            onNextClick = { navController.navigate("list") }
                        )
                    }

                    composable("list") {
                        HalamanListPeserta(
                            pesertaList = pesertaList,
                            onFormClick = { navController.navigate("form") },
                            onHomeClick = { navController.navigate("welcome") }
                        )
                    }

                    composable("form") {
                        HalamanFormulir(
                            onSubmitClick = { data ->
                                pesertaList.add(data)
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}
