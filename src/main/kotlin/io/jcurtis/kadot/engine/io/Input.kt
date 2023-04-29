package io.jcurtis.kadot.engine.io

import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class Input : KeyListener {
    companion object {
        val pressedKeys = mutableListOf<Int>()
    }

    override fun keyTyped(e: KeyEvent?) {}

    override fun keyPressed(e: KeyEvent?) {
        if (!pressedKeys.contains(e?.keyCode)) {
            pressedKeys.add(e?.keyCode!!)
        }
    }

    override fun keyReleased(e: KeyEvent?) {
        if (pressedKeys.contains(e?.keyCode)) {
            pressedKeys.remove(e?.keyCode!!)
        }
    }
}