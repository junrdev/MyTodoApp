package io.github.junrdev.todo.ui.screens.navigation

enum class AppScreens {

    HOME, LOGIN, SIGN_UP, EDIT_TODO, PROFILE_SETTINGS;

    companion object {

        fun fromRoute(route: String?): AppScreens =

            when (route?.substringBefore("/")) {
                HOME.name -> HOME
                LOGIN.name -> LOGIN
                SIGN_UP.name -> SIGN_UP
                EDIT_TODO.name -> EDIT_TODO
                PROFILE_SETTINGS.name -> PROFILE_SETTINGS
                else -> throw IllegalStateException("unable to parse route : $route")
            }

    }
}