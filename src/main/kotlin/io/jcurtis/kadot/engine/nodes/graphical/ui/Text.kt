package io.jcurtis.kadot.engine.nodes.graphical.ui

import io.jcurtis.kadot.engine.nodes.NodeType
import io.jcurtis.kadot.engine.nodes.graphical.GraphicalNode
import java.awt.Graphics2D
import java.awt.image.ImageObserver

class Text(var text: String = "") : GraphicalNode(NodeType.UI, "Text") {
    override fun draw(g: Graphics2D, observer: ImageObserver) {
        g.drawString(text, position.x.toInt(), position.y.toInt())
    }
}