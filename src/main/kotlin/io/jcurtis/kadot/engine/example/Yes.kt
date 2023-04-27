import io.jcurtis.kadot.engine.KadotEngine
import io.jcurtis.kadot.engine.example.Mario

fun main() {
    KadotEngine.root.addChild(Mario())
    KadotEngine.init()
}

