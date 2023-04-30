package io.jcurtis.kadot.engine.io

import io.jcurtis.kadot.engine.utils.Vector2
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener

object Input : KeyListener, MouseListener, MouseMotionListener {
    private val pressedKeys = mutableListOf<Int>()
    private val pressedMouseButtons = mutableListOf<MouseButton>()
    val mousePos = Vector2()

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

    override fun mouseClicked(e: MouseEvent?) {
    }

    override fun mousePressed(e: MouseEvent?) {
        if (!pressedMouseButtons.contains(MouseButton.LEFT)) {
            pressedMouseButtons.add(MouseButton.LEFT)
        }
    }

    override fun mouseReleased(e: MouseEvent?) {
        if (pressedMouseButtons.contains(MouseButton.LEFT)) {
            pressedMouseButtons.remove(MouseButton.LEFT)
        }
    }

    override fun mouseEntered(e: MouseEvent?) {
    }

    override fun mouseExited(e: MouseEvent?) {
    }

    fun isKeyPressed(keyCode: Int): Boolean {
        return pressedKeys.contains(keyCode)
    }

    fun isMousePressed(mb: MouseButton): Boolean {
        return pressedMouseButtons.contains(mb)
    }

    override fun mouseDragged(e: MouseEvent?) {
    }

    override fun mouseMoved(e: MouseEvent?) {
        e ?: return
        mousePos.x = e.x.toDouble()
        mousePos.y = e.y.toDouble() - 31
        // The 31 is for the top of your screen
    }
}