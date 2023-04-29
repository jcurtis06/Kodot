import io.jcurtis.kadot.engine.Kodot
import io.jcurtis.kadot.engine.nodes.graphical.ui.Button
import io.jcurtis.kadot.engine.nodes.graphical.ui.Text

fun main() {
    var count = 0
    val countLabel = Text("0")
    val button = Button("Add!!!!", 40, 30, onClick = { countLabel.text = (++count).toString() })
    countLabel.position.x = 360.0
    countLabel.position.y = 50.0

    button.position.x = 350.0
    button.position.y = 100.0

    Kodot.root.addChild(countLabel)
    Kodot.root.addChild(button)

    Kodot.init()
}