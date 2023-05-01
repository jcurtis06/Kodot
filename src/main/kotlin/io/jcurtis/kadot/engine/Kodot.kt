package io.jcurtis.kadot.engine

import io.jcurtis.kadot.engine.io.Input
import io.jcurtis.kadot.engine.nodes.Node
import io.jcurtis.kadot.engine.nodes.NodeType
import io.jcurtis.kadot.engine.nodes.Root
import io.jcurtis.kadot.engine.nodes.graphical.GraphicalNode
import io.jcurtis.kadot.engine.nodes.physics.CollisionBody
import java.awt.Graphics
import java.awt.Graphics2D
import java.util.concurrent.CopyOnWriteArrayList
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities

@Suppress("MemberVisibilityCanBePrivate")
object Kodot : JPanel(), Runnable {
    // Window settings
    var title: String = "Kodot Engine"
    var screenWidth: Int = 800
    var screenHeight: Int = 600

    // FPS settings
    var maxFrameRate: Int = 240
    var targetTime = 1000 / maxFrameRate
    var lastTime: Long = System.currentTimeMillis()
    var delta: Double = 0.0

    // Node lists
    var nodes = CopyOnWriteArrayList<Node>()
    var colliderNodes = CopyOnWriteArrayList<CollisionBody>()

    // Scene management
    var currentScene: Node = Node(NodeType.NODE, "CurrentScene")

    // Update thread
    val thread: Thread = Thread(this)

    fun init() {
        SwingUtilities.invokeLater {
            val frame = JFrame(title)
            frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            frame.setSize(screenWidth, screenHeight)
            frame.isResizable = false
            frame.setLocationRelativeTo(null)
            frame.isVisible = true

            frame.add(this)
            frame.addKeyListener(Input)
            frame.addMouseListener(Input)
            frame.addMouseMotionListener(Input)
        }

        thread.start()
    }

    fun changeScene(newScene: Node) {
        currentScene = newScene
        nodes.clear()
        nodes.addAll(currentScene.deepChildren)
        nodes.add(newScene)

        for (node in nodes) {
            node.ready()
        }
    }

    private fun update() {
        for (node in nodes) {
            node.update(delta)
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