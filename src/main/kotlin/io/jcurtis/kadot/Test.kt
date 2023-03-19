package io.jcurtis.kadot

import io.jcurtis.kadot.engine.KadotEngine
import io.jcurtis.kadot.engine.nodes.Node
import io.jcurtis.kadot.engine.nodes.NodeType
import io.jcurtis.kadot.engine.nodes.Root
import io.jcurtis.kadot.engine.nodes.Sprite
import io.jcurtis.kadot.engine.nodes.graphical.ui.Text

fun main() {
    val engine = KadotEngine()

    val root = Root()
    val node = Node(NodeType.NODE, "Node")
    val testNode = TestNode()
    val text = Text("Never gonna give you up")
    text.position.y = 100.0

    val spriteNode = Sprite("images/test.png")
    root.addChild(spriteNode)

    root.addChild(node)
    root.addChild(text)
    node.addChild(testNode)

    engine.init()

    println("Node Parent: ${node.parent?.name}")
}