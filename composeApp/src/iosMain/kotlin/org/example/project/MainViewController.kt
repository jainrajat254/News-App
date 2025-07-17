package org.example.project

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.example.project.presentation.root.RootComponent

fun MainViewController() = ComposeUIViewController {
    val rootComponent = remember {
        RootComponent(DefaultComponentContext(LifecycleRegistry()))
    }
    App(rootComponent = rootComponent)
}