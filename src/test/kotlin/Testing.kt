import io.jcurtis.kadot.engine.Kodot
import io.jcurtis.kadot.engine.nodes.graphical.ui.*

fun main() {
    var count = 0
    val countLabel = Text("0")
    val button = Button("Add", 80, 60, onClick = { countLabel.text = (++count).toString() })

    val menu = Container(Alignment.CENTER, Sizing.FULL, 10)
    menu.addChild(countLabel)
    menu.addChild(button)
    menu.addChild(Text("Hello World!"))
    menu.addChild(Text("Hello World!"))
    menu.addChild(Text("Hello World!"))
    menu.addChild(Text("Hello World!"))

    Kodot.root.addChild(menu)

    Kodot.init()
}