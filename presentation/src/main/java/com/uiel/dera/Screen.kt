package com.uiel.dera


sealed class Screen(val route: String) {
    object SignIn : Screen("signin")
    object SignUp : Screen("signup")
    object Main : Screen("main")
    object Alarm : Screen("alarm")
    object Write : Screen("write")
}