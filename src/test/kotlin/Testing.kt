import io.jcurtis.kadot.engine.Kodot
import io.jcurtis.kadot.engine.nodes.Sprite

fun main() {
    val icon = Sprite("images/icon.png")

    icon.position.x = 100.0

    Kodot.root.addChild(icon)

    Kodot.init()
}