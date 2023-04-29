package io.jcurtis.kadot.engine.nodes.graphical.ui

import io.jcurtis.kadot.engine.nodes.NodeType
import io.jcurtis.kadot.engine.nodes.graphical.GraphicalNode
import java.awt.Graphics2D
import java.awt.image.ImageObserver

class Text(var text: String = "") : UI(0, 0) {

    override fun draw(g: Graphics2D, observer: ImageObserver) {
        width = g.fontMetrics.stringWidth(text)
        height = g.fontMetrics.height
        g.drawString(text, position.x.toInt(), position.y.toInt())
    }
}