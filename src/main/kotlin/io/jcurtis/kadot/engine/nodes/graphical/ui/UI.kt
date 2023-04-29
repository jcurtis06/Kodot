package io.jcurtis.kadot.engine.nodes.graphical.ui

import io.jcurtis.kadot.engine.io.Input
import io.jcurtis.kadot.engine.io.MouseButton
import io.jcurtis.kadot.engine.nodes.NodeType
import io.jcurtis.kadot.engine.nodes.graphical.GraphicalNode
import java.awt.Graphics2D
import java.awt.image.ImageObserver

open class UI(
    var width: Int,
    var height: Int,
): GraphicalNode(NodeType.UI, "UI") {
    private var isOver: Boolean = false
    private var isMouseDown: Boolean = false

    private fun mouseInBounds() {
        val mousePos = Input.mousePos

        if (mousePos.x >= position.x && mousePos.x <= position.x + width) {
            if (mousePos.y >= position.y && mousePos.y <= position.y + height) {
                if (!isOver) {
                    isOver = true
                    mouseEnter()
                }
            } else {
                isOver = false
                mouseLeave()
            }
        } else {
            isOver = false
            mouseLeave()
        }
    }

    open fun mouseEnter() {

    }

    open fun mouseLeave() {

    }

    open fun mouseDown() {

    }

    open fun mouseUp() {

    }

    open fun mouseClick() {

    }

    override fun update(delta: Double) {
        super.update(delta)
        mouseInBounds()
        if (isOver && Input.isMousePressed(MouseButton.LEFT)) {
            if (!isMouseDown) {
                isMouseDown = true
                mouseDown()
                mouseClick()
            }
        }
        else {
            if(isMouseDown)
                mouseUp()
            isMouseDown = false
        }
    }

    override fun draw(g: Graphics2D, observer: ImageObserver) {
    }
}