package io.jcurtis.kadot

import io.jcurtis.kadot.engine.KadotEngine
import io.jcurtis.kadot.engine.nodes.Root

fun main() {
    val engine = KadotEngine()
    val root = Root()

    root.addChild(Player())

    engine.init()
}