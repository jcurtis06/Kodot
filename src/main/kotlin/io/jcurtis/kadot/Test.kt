package io.jcurtis.kadot

import androidx.compose.ui.window.application
import io.jcurtis.kadot.engine.KadotEngine

fun main() = application {
    val engine = KadotEngine()
    engine.init(this)
}