package io.jcurtis.kadot.engine.nodes.graphical.ui

import java.awt.Graphics2D
import java.awt.image.ImageObserver

class Button(
    var text: String,
    width: Int,
    height: Int,
    private var onEnter: () -> Unit = {},
    private var onLeave: () -> Unit = {},
    private var onMouseDown: () -> Unit = {},
    private var onMouseUp: () -> Unit = {},
    private var onClick: (Button) -> Unit = {}
): UI(width, height) {
    override fun draw(g: Graphics2D, observer: ImageObserver) {
        g.drawRect(position.x.toInt(), position.y.toInt(), width, height)

        val textWidth = g.fontMetrics.stringWidth(text)
        val textHeight = g.fontMetrics.height
        g.drawString(text, position.x.toInt() + (width / 2) - (textWidth / 2), position.y.toInt() + (height / 2) + (textHeight / 2))
    }

    override fun mouseEnter() {
        onEnter()
    }

    override fun mouseLeave() {
        onLeave()
    }

    override fun mouseDown() {
        onMouseDown()
    }

    override fun mouseUp() {
        onMouseUp()
    }

    override fun mouseClick() {
        onClick(this)
    }
}