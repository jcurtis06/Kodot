import io.jcurtis.kadot.engine.Kodot
import io.jcurtis.kadot.engine.io.Input
import io.jcurtis.kadot.engine.nodes.Node
import io.jcurtis.kadot.engine.nodes.NodeType
import io.jcurtis.kadot.engine.nodes.Root
import io.jcurtis.kadot.engine.nodes.graphical.ui.*
import java.awt.event.KeyEvent

fun main() {
    Kodot.changeScene(SceneA())

    Kodot.init()
}

class SceneA: Node(NodeType.NODE, "Scene A") {
    init {
        val text = Text("Scene A")
        text.position.x = 100.0
        text.position.y = 100.0
        addChild(text)
    }

    override fun ready() {
        println("Scene A ready")
    }

    override fun update(delta: Double) {
        super.update(delta)

        if (Input.isKeyPressed(KeyEvent.VK_B)) {
            Kodot.changeScene(SceneB())
        }
    }
}

class SceneB: Node(NodeType.NODE, "Scene B") {
    init {
        name = "Scene B"
        val text = Text("Scene B")
        text.position.x = 100.0
        text.position.y = 100.0
        addChild(text)
    }

    override fun ready() {
        val text = Text("Scene Poop")
        text.position.x = 100.0
        text.position.y = 200.0
        addChild(text)

        println("Scene B ready")
    }

    override fun update(delta: Double) {
        super.update(delta)

        if (Input.isKeyPressed(KeyEvent.VK_A)) {
            Kodot.changeScene(SceneA())
        }
    }
}