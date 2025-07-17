package org.example.project.presentation.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.replaceCurrent
import org.example.project.presentation.feature.donate.DonationComponent
import org.example.project.presentation.feature.home.HomeComponent
import org.example.project.presentation.feature.language.LanguageSelectionComponent
import org.example.project.presentation.feature.login.getOtp.LoginOtpRequestComponent
import org.example.project.presentation.feature.login.verifyOtp.LoginOtpVerifyComponent
import org.example.project.presentation.feature.onboarding.WelcomeComponent
import org.example.project.presentation.feature.profile.ProfileComponent
import org.example.project.presentation.feature.signup.getOtp.SignupOtpRequestComponent
import org.example.project.presentation.feature.signup.verifyOtp.SignupOtpVerifyComponent

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
                    onNotificationsClicked = {},
                    onSavedClicked = {},
                    onSurveysClicked = {},
                    onContentLanguageClicked = { navigation.pushNew(Configuration.LanguageSelectionScreen) },
                    onDonateClicked = { navigation.pushNew(Configuration.DonationScreen) },
                    onLogoutClicked = {
                        navigation.replaceCurrent(Configuration.LoginOtpRequestScreen)
                    }
                )
            )

            is Configuration.ProfileScreen -> Child.ProfileScreen(
                component = ProfileComponent(

                )
            )

            is Configuration.LanguageSelectionScreen -> Child.LanguageSelectionScreen(
                component = LanguageSelectionComponent(
                    componentContext = context,
                    onSaveClicked = { navigation.pop() },
                    onSkipClicked = { navigation.pop() }
                )
            )

            is Configuration.DonationScreen -> Child.DonationScreen(
                component = DonationComponent(

                )
            )
        }
    }

}