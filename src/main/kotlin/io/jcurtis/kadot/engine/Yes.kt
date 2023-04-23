package io.jcurtis.kadot.engine

import io.jcurtis.kadot.engine.nodes.Root

fun main() {
    val engine = KadotEngine()

    val root = Root()
    root.addChild(Mario())

    engine.init()
}