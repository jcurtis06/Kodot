package io.jcurtis.platformer

import io.jcurtis.kadot.engine.Kodot
import io.jcurtis.platformer.scenes.Game
import io.jcurtis.platformer.scenes.MainMenu

fun main() {
    Kodot.changeScene(MainMenu())

    Kodot.init()
}