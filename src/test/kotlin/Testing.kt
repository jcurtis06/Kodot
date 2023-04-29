import io.jcurtis.kadot.engine.Kodot
import io.jcurtis.kadot.engine.nodes.Sprite
import io.jcurtis.kadot.engine.nodes.graphical.ui.Text

fun main() {
    val icon = Sprite("images/icon.png")
    val text = Text("Hello Kodot!")

    icon.position.x = 141.0
    icon.position.y = 212.0

    text.position.x = 350.0
    text.position.y = 50.0

    Kodot.root.addChild(icon)
    Kodot.root.addChild(text)

    Kodot.init()
}