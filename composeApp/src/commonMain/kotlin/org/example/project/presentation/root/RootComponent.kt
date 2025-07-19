package org.example.project.presentation.root

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.replaceCurrent
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
import org.example.project.presentation.navigation.Tab

class RootComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {

    private val navigation = StackNavigation<Configuration>()
    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.HomeScreen,
        handleBackButton = true,
        childFactory = ::createChild
    )

    var currentTab: Tab by mutableStateOf(Tab.Home)
        private set

    fun onTabSelected(tab: Tab) {
        currentTab = tab
        navigation.replaceCurrent(
            when (tab) {
                Tab.Home -> Configuration.HomeScreen
                Tab.Discover -> Configuration.DiscoverScreen
                Tab.Shorts -> Configuration.ShortsScreen
                Tab.News -> Configuration.NewsScreen
                Tab.Donate -> Configuration.DonationScreen
            }
        )
    }

    private fun createChild(
        configuration: Configuration,
        context: ComponentContext
    ): Child {
        return when (configuration) {
            is Configuration.WelcomeScreen -> Child.WelcomeScreen(
                component = WelcomeComponent(
                    componentContext = context,
                    onLoginClicked = {
                        navigation.replaceCurrent(Configuration.LoginOtpRequestScreen)
                    },
                    onSignupClicked = {
                        navigation.replaceCurrent(Configuration.SignupOtpRequestScreen)
                    }
                )
            )

            is Configuration.LoginOtpRequestScreen -> Child.LoginOtpScreen(
                component = LoginOtpRequestComponent(
                    componentContext = context,
                    onGetOtp = { phone ->
                        navigation.pushNew(Configuration.LoginOtpVerifyScreen(phoneNumber = phone))
                    },
                    onSignup = {
                        navigation.replaceCurrent(Configuration.SignupOtpRequestScreen)
                    }
                )
            )

            is Configuration.LoginOtpVerifyScreen -> Child.LoginOtpVerifyScreen(
                component = LoginOtpVerifyComponent(
                    phoneNumber = configuration.phoneNumber,
                    componentContext = context,
                    onVerifyOtp = { navigation.replaceCurrent(Configuration.HomeScreen) },
                    onSignup = {
                        navigation.replaceCurrent(Configuration.SignupOtpRequestScreen)
                    }
                )
            )

            is Configuration.SignupOtpRequestScreen -> Child.SignupOtpScreen(
                SignupOtpRequestComponent(
                    componentContext = context,
                    onGetOtp = { phone ->
                        navigation.pushNew(Configuration.SignupOtpVerifyScreen(phone))
                    },
                    onLogin = {
                        navigation.replaceCurrent(Configuration.LoginOtpRequestScreen)
                    }
                )
            )

            is Configuration.SignupOtpVerifyScreen -> Child.SignupOtpVerifyScreen(
                SignupOtpVerifyComponent(
                    phoneNumber = configuration.phoneNumber,
                    componentContext = context,
                    onVerifyOtp = { navigation.replaceCurrent(Configuration.HomeScreen) },
                    onLogin = {
                        navigation.replaceCurrent(Configuration.LoginOtpRequestScreen)
                    },
                )
            )

            is Configuration.HomeScreen -> Child.HomeScreen(
                component = HomeComponent(
                    componentContext = context,
                    onViewProfileClicked = {
                        navigation.pushNew(Configuration.ProfileScreen)
                    },
                    onNotificationsClicked = { navigation.pushNew(Configuration.NotificationsScreen) },
                    onSavedClicked = { navigation.pushNew(Configuration.SavedItemsScreen) },
                    onSurveysClicked = { navigation.pushNew(Configuration.SurveysScreen) },
                    onContentLanguageClicked = { navigation.pushNew(Configuration.LanguageSelectionScreen) },
                    onDonateClicked = { navigation.pushNew(Configuration.DonationScreen) },
                    onLogoutClicked = {
                        navigation.replaceCurrent(Configuration.LoginOtpRequestScreen)
                    }
                )
            )

            is Configuration.ProfileScreen -> Child.ProfileScreen(
                component = ProfileComponent(
                    componentContext = context,
                    onBackClicked = { navigation.pop() },
                    onSaveClicked = { navigation.pop() }
                )
            )

            is Configuration.NotificationsScreen -> Child.NotificationsScreen(
                component = NotificationsComponent(
                    componentContext = context,
                    onBackClicked = { navigation.pop() }
                )
            )

            is Configuration.SavedItemsScreen -> Child.SavedItemsScreen(
                component = SavedItemsComponent(
                    componentContext = context,
                    onBackClicked = { navigation.pop() }
                )
            )

            is Configuration.SurveysScreen -> Child.SurveysScreen(
                component = SurveysComponent(
                    componentContext = context,
                    onBackClicked = { navigation.pop() }
                )
            )

            is Configuration.LanguageSelectionScreen -> Child.LanguageSelectionScreen(
                component = LanguageSelectionComponent(
                    componentContext = context,
                    onSaveClicked = { navigation.pop() },
                    onSkipClicked = { navigation.pop() },
                    onBackClicked = { navigation.pop() }
                )
            )

            is Configuration.DonationScreen -> Child.DonationScreen(
                component = DonateComponent(
                    componentContext = context,
                    onDonateClicked = { navigation.pushNew(Configuration.PaymentScreen) }
                )
            )

            is Configuration.PaymentScreen -> Child.PaymentScreen(
                component = PaymentComponent(
                    componentContext = context,
                    onBackClicked = { navigation.popTo(0) },
                )
            )

            is Configuration.NewsScreen -> Child.NewsScreen(
                component = NewsComponent(
                )
            )

            is Configuration.DiscoverScreen -> Child.DiscoverScreen(
                component = DiscoverComponent(
                )
            )

            is Configuration.ShortsScreen -> Child.ShortsScreen(
                component = ShortsComponent(
                )
            )
        }
    }
}