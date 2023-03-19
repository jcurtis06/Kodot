package io.jcurtis.kadot.engine.nodes

import io.jcurtis.kadot.engine.KadotEngine
import io.jcurtis.kadot.engine.utils.Vector2

open class Node(var type: NodeType, var name: String, var position: Vector2 = Vector2()) {
    private val children = mutableListOf<Node>()

    var parent: Node? = null

    fun addChild(node: Node) {
        children.add(node)
        node.parent = this
        node.onTreeEnter()
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
        KadotEngine.registerNode(this)
    }

    open fun update(delta: Long) {}

    open fun ready() {}
}