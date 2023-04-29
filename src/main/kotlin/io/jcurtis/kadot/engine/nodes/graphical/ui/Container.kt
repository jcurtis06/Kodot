package io.jcurtis.kadot.engine.nodes.graphical.ui

import io.jcurtis.kadot.engine.Kodot
import io.jcurtis.kadot.engine.utils.Vector2

class Container(private val alignment: Alignment, private val sizing: Sizing = Sizing.FIXED, val spacing: Int = 0) : UI(0, 0) {
    init {
        if (sizing == Sizing.FULL) {
            println("Using Sizing.FULL, w: ${Kodot.screenWidth}, h: ${Kodot.screenHeight}")
            width = Kodot.screenWidth
            height = Kodot.screenHeight
        }

        if (sizing == Sizing.FIXED) {
            require(width > 0 && height > 0) { "Width and height must be greater than 0 when using Sizing.FIXED" }
        }
    }

    override fun update(delta: Double) {
        super.update(delta)

        val centerX = position.x + width / 2
        var centerY = position.y + height / 2

        var totalHeight = 0

        for (child in children) {
            if (child !is UI) continue
            totalHeight += child.height + spacing
        }
        totalHeight -= spacing

        centerY -= totalHeight / 2

        for (child in children) {
            if (child !is UI) continue
            child.position = Vector2(centerX - child.width / 2, centerY)
            centerY += child.height + spacing
        }
    }
}