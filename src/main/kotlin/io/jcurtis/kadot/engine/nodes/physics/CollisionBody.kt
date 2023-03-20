package io.jcurtis.kadot.engine.nodes.physics

import io.jcurtis.kadot.engine.nodes.Node
import io.jcurtis.kadot.engine.nodes.NodeType

@Suppress("unused")
open class CollisionBody(type: NodeType, name: String) : Node(type, name) {
    var mask = arrayListOf<Int>()
    var layer = 0
        set(value) {
            field = value
            this.mask.add(value)
        }

    var collider: CollisionShape? = null

    init {
        this.mask.add(0)
    }

    fun setMask(vararg mask: Int) {
        this.mask.clear()
        this.mask.addAll(mask.toList())
    }
}