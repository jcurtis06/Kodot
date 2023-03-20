package io.jcurtis.kadot.engine.nodes.physics

import io.jcurtis.kadot.engine.nodes.NodeType

class StaticBody(collisionShape: CollisionShape): CollisionBody(NodeType.STATIC_BODY, "StaticBody") {
    init {
        addChild(collisionShape)
        collider = collisionShape
    }
}