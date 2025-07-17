package org.example.project.presentation.root

import kotlinx.serialization.Serializable


@Serializable
sealed class Configuration {

    @Serializable
    data object WelcomeScreen : Configuration()

    @Serializable
    data object LoginOtpRequestScreen : Configuration()

    @Serializable
    data class LoginOtpVerifyScreen(val phoneNumber: String) : Configuration()

    @Serializable
    data object SignupOtpRequestScreen : Configuration()

    @Serializable
    data class SignupOtpVerifyScreen(val phoneNumber: String) : Configuration()

    @Serializable
    data object HomeScreen : Configuration()

    @Serializable
    data object ProfileScreen : Configuration()

    //        @Serializable
//        data object NotificationsScreen : Configuration()
//
//        @Serializable
//        data object SavedItemsScreen : Configuration()
//
//        @Serializable
//        data object SurveysScreen : Configuration()
//
    @Serializable
    data object LanguageSelectionScreen : Configuration()

    @Serializable
    data object DonationScreen : Configuration()
}
