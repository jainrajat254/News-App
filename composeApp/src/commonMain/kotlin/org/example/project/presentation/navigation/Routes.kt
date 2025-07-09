package org.example.project.presentation.navigation

sealed class Routes(val route: String) {

    data object Login : Routes("login")
}