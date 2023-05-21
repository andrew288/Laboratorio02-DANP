package com.example.mytutorialapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mytutorialapp.Navigation.Destinations
import com.example.mytutorialapp.Presentation.CreateAsistente
import com.example.mytutorialapp.Presentation.Model.Asistente
import com.example.mytutorialapp.Presentation.Views.EditAsistente
import com.example.mytutorialapp.Presentation.Views.ListAsistente
import com.example.mytutorialapp.ui.theme.MyTutorialAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTutorialAppTheme {
                val listaAsistentes = remember { mutableStateListOf<Asistente>() }
                val navigationController = rememberNavController()
                NavHost(
                    navController = navigationController,
                    startDestination = Destinations.ListScreen.route
                ) {
                    composable(Destinations.ListScreen.route) {
                        ListAsistente(
                            navController = navigationController,
                            listaAsistentes = listaAsistentes
                        )
                    }
                    composable(Destinations.CreateScreen.route) {
                        CreateAsistente(
                            navController = navigationController,
                            listaAsistentes = listaAsistentes
                        )
                    }
                    composable(
                        "${Destinations.EditScreen.route}/{index}",
                        arguments = listOf(navArgument("index") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val index = backStackEntry.arguments?.getInt("index") ?: 0
                        EditAsistente(
                            navController = navigationController,
                            listaAsistentes = listaAsistentes,
                            index =  index
                        )
                    }
                }
            }
        }
    }
}