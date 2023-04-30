import io.jcurtis.kadot.engine.Kodot
import io.jcurtis.kadot.engine.nodes.graphical.ui.*

fun main() {
    val mt = MovementTest()

    Kodot.root.addChild(mt)

    Kodot.init()
}