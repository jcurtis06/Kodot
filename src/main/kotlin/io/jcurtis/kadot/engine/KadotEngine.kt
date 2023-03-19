package io.jcurtis.kadot.engine

import io.jcurtis.kadot.engine.nodes.GraphicalNode
import io.jcurtis.kadot.engine.nodes.Node
import io.jcurtis.kadot.engine.nodes.Sprite
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities

class KadotEngine(
    private var title: String = "Kadot Engine",
    private var width: Int = 800,
    private var height: Int = 600
): JPanel(), ActionListener {
    companion object {
        var nodes = mutableListOf<Node>()

        fun registerNode(node: Node) {
            nodes.add(node)
        }
    }

    fun init() {
        for (node in nodes) {
            node.ready()
        }

        SwingUtilities.invokeLater {
            val frame = JFrame(title)
            frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            frame.setSize(width, height)
            frame.isResizable = false
            frame.setLocationRelativeTo(null)
            frame.isVisible = true

            frame.add(this)
            frame.addKeyListener(Input())
        }
    }

    private fun update() {
        for (node in nodes) {
            node.update()
        }
    }

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)

        val g2d = g as Graphics2D
        for (n in nodes) {
            if (n is GraphicalNode) {
                n.draw(g2d, this)
            }
        }
    }

    override fun actionPerformed(e: ActionEvent?) {
        update()
        repaint()
    }
}
