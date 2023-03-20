package io.jcurtis.kadot.engine.nodes.physics

import io.jcurtis.kadot.engine.nodes.Node
import io.jcurtis.kadot.engine.nodes.NodeType
import java.awt.Rectangle

@Suppress("Unused", "MemberVisibilityCanBePrivate")
class CollisionShape(var width: Int, var height: Int) : Node(NodeType.COLLISION_SHAPE, "CollisionShape") {
    var shape: CollisionShape = CollisionShape.RECTANGLE

    fun getBounds(): Rectangle {
        return Rectangle(position.x.toInt(), position.y.toInt(), width, height)
    }

    enum class CollisionShape {
        RECTANGLE,
        CIRCLE,
        POLYGON,
    }
}