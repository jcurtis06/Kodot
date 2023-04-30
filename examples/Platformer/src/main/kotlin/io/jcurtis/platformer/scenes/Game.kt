package io.jcurtis.platformer.scenes

import io.jcurtis.kadot.engine.nodes.Node
import io.jcurtis.kadot.engine.nodes.NodeType

class Game : Node(NodeType.NODE, "Game") {
    init {
        val p = Player()
        p.position.x = 100.0
    }
}