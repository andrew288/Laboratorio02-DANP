package com.example.mytutorialapp.Navigation

sealed class Destinations(
    val route: String
){
    object CreateScreen: Destinations("CreateScreen")
    object ListScreen: Destinations("ListScreen")
    object EditScreen: Destinations("EditScreen")
}