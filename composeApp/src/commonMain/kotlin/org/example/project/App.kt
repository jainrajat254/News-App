package org.example.project

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.example.project.navigation.BottomNavigationBar
import org.example.project.presentation.feature.discover.DiscoverScreen
import org.example.project.presentation.feature.donate.DonateScreen
import org.example.project.presentation.feature.home.HomeScreen
import org.example.project.presentation.feature.language.LanguageSelectionScreen
import org.example.project.presentation.feature.login.getOtp.LoginOtpRequestScreen
import org.example.project.presentation.feature.login.verifyOtp.LoginOtpVerifyScreen
import org.example.project.presentation.feature.news.NewsScreen
import org.example.project.presentation.feature.notifications.NotificationsScreen
import org.example.project.presentation.feature.onboarding.WelcomeScreen
import org.example.project.presentation.feature.payment.PaymentStatusScreen
import org.example.project.presentation.feature.profile.ProfileScreen
import org.example.project.presentation.feature.saved.SavedItemsScreen
import org.example.project.presentation.feature.shorts.ShortsScreen
import org.example.project.presentation.feature.signup.getOtp.SignupOtpRequestScreen
import org.example.project.presentation.feature.signup.verifyOtp.SignupOtpVerifyScreen
import org.example.project.presentation.feature.survey.SurveyScreen
import org.example.project.presentation.root.Child
import org.example.project.presentation.root.Configuration
import org.example.project.presentation.root.RootComponent

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun App(rootComponent: RootComponent) {
    MaterialTheme {
        val childStack by rootComponent.childStack.subscribeAsState()
        val currentTab = rootComponent.currentTab
        var isDrawerClosed by remember { mutableStateOf(true) }


        Column {
            Box(modifier = Modifier.weight(1f)) {
                Children(stack = childStack, animation = stackAnimation(slide())) { child ->
                    when (val instance = child.instance) {
                        is Child.WelcomeScreen -> WelcomeScreen(instance.component)
                        is Child.LoginOtpScreen -> LoginOtpRequestScreen(instance.component)
                        is Child.LoginOtpVerifyScreen -> LoginOtpVerifyScreen(instance.component)
                        is Child.SignupOtpScreen -> SignupOtpRequestScreen(instance.component)
                        is Child.SignupOtpVerifyScreen -> SignupOtpVerifyScreen(instance.component)
                        is Child.HomeScreen -> HomeScreen(
                            instance.component,
                            onDrawerStateChanged = { isClosed -> isDrawerClosed = isClosed }
                        )

                        is Child.ProfileScreen -> ProfileScreen(instance.component)
                        is Child.NotificationsScreen -> NotificationsScreen(instance.component)
                        is Child.SavedItemsScreen -> SavedItemsScreen(instance.component)
                        is Child.SurveysScreen -> SurveyScreen(instance.component)
                        is Child.LanguageSelectionScreen -> LanguageSelectionScreen(instance.component)
                        is Child.DonationScreen -> DonateScreen(instance.component)
                        is Child.PaymentScreen -> PaymentStatusScreen(instance.component)
                        is Child.DiscoverScreen -> DiscoverScreen()
                        is Child.NewsScreen -> NewsScreen()
                        is Child.ShortsScreen -> ShortsScreen()
                    }
                }
            }
            val bottomBarVisible = childStack.active.configuration in listOf(
                Configuration.HomeScreen,
                Configuration.DiscoverScreen,
                Configuration.ShortsScreen,
                Configuration.NewsScreen,
                Configuration.DonationScreen
            ) && isDrawerClosed

            if (bottomBarVisible) {
                BottomNavigationBar(
                    selectedTab = currentTab,
                    onTabSelected = rootComponent::onTabSelected
                )
            }
        }
    }
}