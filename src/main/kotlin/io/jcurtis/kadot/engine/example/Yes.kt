import io.jcurtis.kadot.engine.Kodot
import io.jcurtis.kadot.engine.example.Mario

fun main() {
    Kodot.root.addChild(Mario())
    Kodot.init()
}

