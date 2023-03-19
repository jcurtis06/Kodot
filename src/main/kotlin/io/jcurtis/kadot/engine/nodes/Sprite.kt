package io.jcurtis.kadot.engine.nodes

import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.awt.image.ImageObserver
import java.io.File
import javax.imageio.ImageIO

class Sprite(resPath: String) : GraphicalNode(NodeType.SPRITE, "Sprite") {
    private val sprite: BufferedImage = ImageIO.read(File(resPath))

    override fun draw(g: Graphics2D, observer: ImageObserver) {
        g.drawImage(sprite, position.x.toInt(), position.y.toInt(), observer)
    }
}