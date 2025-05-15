package net.alonzochoque.indriveclone.presentation.navigation.graph.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import net.alonzochoque.indriveclone.presentation.navigation.Graph
import net.alonzochoque.indriveclone.presentation.navigation.screen.auth.AuthScreen
import net.alonzochoque.indriveclone.presentation.screens.auth.login.LoginScreen
import net.alonzochoque.indriveclone.presentation.screens.auth.register.RegisterScreen


fun NavGraphBuilder.AuthNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Register.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navHostController)
        }

        composable(route = AuthScreen.Register.route) {
            RegisterScreen(navHostController)
        }
    }

}