package io.jcurtis.kadot.engine

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState

class KadotEngine(
    private var title: String = "Kadot Engine",
    private var width: Int = 800,
    private var height: Int = 600
) {
    @Composable
    fun init(applicationScope: ApplicationScope) {
        return Window(
            onCloseRequest = { applicationScope.exitApplication() },
            title = title,
            state = rememberWindowState(width = width.dp, height = height.dp)
        ) {
            // TODO: Handle Node rendering
        }
    }
}
