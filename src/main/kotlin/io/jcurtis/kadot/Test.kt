package io.jcurtis.kadot

import androidx.compose.ui.window.application
import io.jcurtis.kadot.engine.KadotEngine
import io.jcurtis.kadot.engine.nodes.Node
import io.jcurtis.kadot.engine.nodes.NodeType
import io.jcurtis.kadot.engine.nodes.Root

fun main() = application {
    val engine = KadotEngine()

    val root = Root()
    val node = Node(NodeType.NODE, "Node")
    val testNode = TestNode()

    root.addChild(node)
    node.addChild(testNode)

    engine.init(this)

    println("Node Parent: ${node.parent?.name}")
}