package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.example.project.presentation.feature.donate.DonateScreen
import org.example.project.presentation.feature.home.HomeScreen
import org.example.project.presentation.feature.language.LanguageSelectionScreen
import org.example.project.presentation.feature.login.getOtp.LoginOtpRequestScreen
import org.example.project.presentation.feature.login.verifyOtp.LoginOtpVerifyScreen
import org.example.project.presentation.feature.onboarding.WelcomeScreen
import org.example.project.presentation.feature.profile.ProfileScreen
import org.example.project.presentation.feature.signup.getOtp.SignupOtpRequestScreen
import org.example.project.presentation.feature.signup.verifyOtp.SignupOtpVerifyScreen
import org.example.project.presentation.root.Child
import org.example.project.presentation.root.RootComponent

@Composable
fun App(rootComponent: RootComponent) {
    MaterialTheme {
        val childStack by rootComponent.childStack.subscribeAsState()

        Children(stack = childStack, animation = stackAnimation(slide())) { child ->
            when (val instance = child.instance) {
                is Child.WelcomeScreen -> WelcomeScreen(instance.component)
                is Child.LoginOtpScreen -> LoginOtpRequestScreen(instance.component)
                is Child.LoginOtpVerifyScreen -> LoginOtpVerifyScreen(instance.component)
                is Child.SignupOtpScreen -> SignupOtpRequestScreen(instance.component)
                is Child.SignupOtpVerifyScreen -> SignupOtpVerifyScreen(instance.component)
                is Child.HomeScreen -> HomeScreen(instance.component)
                is Child.ProfileScreen -> ProfileScreen(instance.component)
                is Child.DonationScreen -> DonateScreen(instance.component)
                is Child.LanguageSelectionScreen -> LanguageSelectionScreen(instance.component)
            }
        }
    }
}



