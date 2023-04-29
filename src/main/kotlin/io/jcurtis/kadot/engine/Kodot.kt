package io.jcurtis.kadot.engine

import io.jcurtis.kadot.engine.io.Input
import io.jcurtis.kadot.engine.nodes.Node
import io.jcurtis.kadot.engine.nodes.Root
import io.jcurtis.kadot.engine.nodes.graphical.GraphicalNode
import io.jcurtis.kadot.engine.nodes.physics.CollisionBody
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities

@Suppress("MemberVisibilityCanBePrivate")
object Kodot : JPanel(), Runnable{
    var title: String = "Kadot Engine"
    var screenWidth: Int = 800
    var screenHeight: Int = 600
    var maxFrameRate: Int = 240
    var root: Root = Root()
    var targetTime = 1000 / maxFrameRate
    var lastTime: Long = System.currentTimeMillis()
    var nodes = mutableListOf<Node>()
    var colliderNodes = mutableListOf<CollisionBody>()
    var delta: Double = 0.0

    val thread: Thread = Thread(this)
    fun registerNode(node: Node) {
        nodes.add(node)

        if (node is CollisionBody) {
            colliderNodes.add(node)
        }
    }

    fun init() {
        for (node in nodes) {
            node.ready()
        }

        SwingUtilities.invokeLater {
            val frame = JFrame(title)
            frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            frame.setSize(screenWidth, screenHeight)
            frame.isResizable = false
            frame.setLocationRelativeTo(null)
            frame.isVisible = true

            frame.add(this)
            frame.addKeyListener(Input())
        }

        thread.start()
    }

    private fun update() {
        for (node in nodes) {
            node.update((delta))
        }
        repaint()
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

    override fun run() {
        var currentTime: Long
        var elapsedTime: Long
        var sleepTime: Long

        while (true) {
            currentTime = System.currentTimeMillis()
            elapsedTime = currentTime - lastTime
            delta = elapsedTime / 1000.0

            if (elapsedTime < targetTime) {
                sleepTime = targetTime - elapsedTime

                try {
                    Thread.sleep(sleepTime)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }

            update()
            lastTime = currentTime
        }
    }
}