package org.example.project.presentation.root

import org.example.project.presentation.feature.discover.DiscoverComponent
import org.example.project.presentation.feature.donate.DonateComponent
import org.example.project.presentation.feature.home.HomeComponent
import org.example.project.presentation.feature.language.LanguageSelectionComponent
import org.example.project.presentation.feature.login.getOtp.LoginOtpRequestComponent
import org.example.project.presentation.feature.login.verifyOtp.LoginOtpVerifyComponent
import org.example.project.presentation.feature.news.NewsComponent
import org.example.project.presentation.feature.notifications.NotificationsComponent
import org.example.project.presentation.feature.onboarding.WelcomeComponent
import org.example.project.presentation.feature.payment.PaymentComponent
import org.example.project.presentation.feature.profile.ProfileComponent
import org.example.project.presentation.feature.saved.SavedItemsComponent
import org.example.project.presentation.feature.shorts.ShortsComponent
import org.example.project.presentation.feature.signup.getOtp.SignupOtpRequestComponent
import org.example.project.presentation.feature.signup.verifyOtp.SignupOtpVerifyComponent
import org.example.project.presentation.feature.survey.SurveysComponent

sealed class Child {
    data class WelcomeScreen(val component: WelcomeComponent) : Child()
    data class LoginOtpScreen(val component: LoginOtpRequestComponent) : Child()
    data class LoginOtpVerifyScreen(val component: LoginOtpVerifyComponent) : Child()
    data class SignupOtpScreen(val component: SignupOtpRequestComponent) : Child()
    data class SignupOtpVerifyScreen(val component: SignupOtpVerifyComponent) : Child()
    data class HomeScreen(val component: HomeComponent) : Child()
    data class ProfileScreen(val component: ProfileComponent) : Child()
    data class NotificationsScreen(val component: NotificationsComponent) : Child()
    data class SavedItemsScreen(val component: SavedItemsComponent) : Child()
    data class SurveysScreen(val component: SurveysComponent) : Child()
    data class LanguageSelectionScreen(val component: LanguageSelectionComponent) : Child()
    data class DonationScreen(val component: DonateComponent) : Child()
    data class PaymentScreen(val component: PaymentComponent) : Child()
    data class DiscoverScreen(val component: DiscoverComponent) : Child()
    data class NewsScreen(val component: NewsComponent) : Child()
    data class ShortsScreen(val component: ShortsComponent) : Child()
}
