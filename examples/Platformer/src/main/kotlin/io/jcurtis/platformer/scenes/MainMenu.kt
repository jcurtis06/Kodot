package io.jcurtis.platformer.scenes

import io.jcurtis.kadot.engine.nodes.Node
import io.jcurtis.kadot.engine.nodes.NodeType
import io.jcurtis.kadot.engine.nodes.graphical.ui.*

// Container.kt should be able to be extended from, but this works for now
class MainMenu() : Node(NodeType.UI, "MainMenu") {
    init {
        val menu = Container(Alignment.CENTER, Sizing.FULL, 10)

        menu.addChild(Text("Kodot Platformer"))
        menu.addChild(Button("Play", 100, 30, onClick = { println("Play") }))
        menu.addChild(Button("Settings", 100, 30, onClick = { println("Play") }))
        menu.addChild(Button("Quit", 100, 30, onClick = { println("Play") }))

        addChild(menu)
    }
}