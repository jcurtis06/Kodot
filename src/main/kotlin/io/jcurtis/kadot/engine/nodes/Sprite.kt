package io.jcurtis.kadot.engine.nodes

import java.awt.Graphics
import java.awt.image.BufferedImage
import java.awt.image.ImageObserver
import java.io.File
import javax.imageio.ImageIO

class Sprite(private var resPath: String) : Node(NodeType.SPRITE, "Sprite") {
    private val sprite: BufferedImage = ImageIO.read(File(resPath))

    fun draw(g: Graphics, observer: ImageObserver) {
        g.drawImage(sprite, position.x.toInt(), position.y.toInt(), observer)
    }
}