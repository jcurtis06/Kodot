package io.jcurtis.platformer.scenes

import io.jcurtis.kadot.engine.nodes.Node
import io.jcurtis.kadot.engine.nodes.NodeType
import io.jcurtis.kadot.engine.nodes.Sprite
import io.jcurtis.kadot.engine.nodes.physics.CollisionBody
import io.jcurtis.kadot.engine.nodes.physics.CollisionShape

class Game : Node(NodeType.NODE, "Game") {
    init {
        val p = Player()
        p.position.x = 100.0
        addChild(p)

        val platform = Sprite("assets/platform.png")
        platform.position.y = 500.0
        platform.position.x = 12.5

        val collider = CollisionBody(NodeType.COLLISION_SHAPE, "platform_collider")
        val shape = CollisionShape(775, 100)
        collider.collider = shape
        collider.addChild(shape)
        platform.addChild(collider)

        addChild(platform)
    }
}