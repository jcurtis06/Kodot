package io.jcurtis.kadot.engine.nodes

import io.jcurtis.kadot.engine.Kodot
import io.jcurtis.kadot.engine.utils.Vector2

open class Node(var type: NodeType, var name: String, var position: Vector2 = Vector2()) {
    val children = mutableListOf<Node>()

    var parent: Node? = null

    fun addChild(node: Node) {
        children.add(node)
        node.parent = this
        node.onTreeEnter()
        onChildAdded(node)
    }

    fun queueFree() {
        parent?.removeChild(this)
    }

    fun removeChild(node: Node) {
        if (!node.children.isEmpty()) {
            for (child in node.children) {
                removeChild(child)
            }
        }

        children.remove(node)
    }

    fun removeChild(index: Int) {
        removeChild(children[index])
    }

    fun getTreeRoot(): Root {
        var temp = parent

        while (temp?.parent != null) {
            temp = temp.parent
        }

        return temp as Root
    }

    open fun onTreeEnter() {
        Kodot.registerNode(this)
    }

    open fun update(delta: Double) {
        if (parent == null) return
        if (parent!!.type == NodeType.ROOT) return
        if (parent!!.type == NodeType.UI) return
        position = parent!!.position
    }

    open fun ready() {}

    open fun onChildAdded(child: Node) {}
}