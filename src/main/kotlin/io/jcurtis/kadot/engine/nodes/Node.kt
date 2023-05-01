package io.jcurtis.kadot.engine.nodes

import io.jcurtis.kadot.engine.Kodot
import io.jcurtis.kadot.engine.utils.Vector2

open class Node(var type: NodeType, var name: String, var position: Vector2 = Vector2()) {
    // make a mutable list of children nodes. Have a getter that allows for deep iteration in addition to shallow iteration
    var children = arrayListOf<Node>()

    var shallowChildren: ArrayList<Node>
        get() = children
        set(value) {
            children = value
        }

    var deepChildren: ArrayList<Node>
        get() {
            val list = arrayListOf<Node>()
            for (child in children) {
                list.add(child)
                list.addAll(child.deepChildren)
            }
            return list
        }
        set(value) {
            children = value
        }

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

    fun getTreeRoot(): Node {
        if (parent == null) return this
        var temp = parent

        while (temp?.parent != null && temp.type != NodeType.ROOT) {
            temp = temp.parent
        }

        return temp!!
    }

    open fun onTreeEnter() {

    }

    open fun update(delta: Double) {
        if (parent == null) return
        if (parent!!.type == NodeType.ROOT) return
        if (parent!!.type == NodeType.UI) return
        if (parent == Kodot.currentScene) return
        position = parent!!.position
    }

    open fun ready() {}

    open fun onChildAdded(child: Node) {}
}