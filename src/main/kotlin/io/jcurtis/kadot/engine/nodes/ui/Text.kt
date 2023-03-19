package io.jcurtis.kadot.engine.nodes.ui

import io.jcurtis.kadot.engine.nodes.GraphicalNode
import io.jcurtis.kadot.engine.nodes.Node
import io.jcurtis.kadot.engine.nodes.NodeType
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.image.ImageObserver

class Text(var text: String = ""): GraphicalNode(NodeType.UI, "Text") {
    override fun draw(g: Graphics2D, observer: ImageObserver) {
        g.drawString(text, position.x.toInt(), position.y.toInt())
    }
}