package io.jcurtis.kadot

import io.jcurtis.kadot.engine.KadotEngine
import io.jcurtis.kadot.engine.nodes.Sprite
import io.jcurtis.kadot.engine.nodes.physics.CollisionShape
import io.jcurtis.kadot.engine.nodes.physics.KinematicBody

class Player : KinematicBody() {
    val speed = 1.0

    init {
        name = "Player"

        val sprite = Sprite("images/Player.png")
        collider = CollisionShape(32, 32)
        addChild(sprite)
    }

    override fun update(delta: Double) {
        super.update(delta)

        velocity.x = 300 * KadotEngine.delta

        moveAndSlide()
    }
}