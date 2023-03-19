package io.jcurtis.kadot

import io.jcurtis.kadot.engine.nodes.Node
import io.jcurtis.kadot.engine.nodes.NodeType

class TestNode: Node(NodeType.NODE, "Test Node") {
    override fun update(delta: Long) {
        println("Test Node Update")
    }
}