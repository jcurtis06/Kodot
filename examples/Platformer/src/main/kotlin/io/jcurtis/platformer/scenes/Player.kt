package io.jcurtis.platformer.scenes

import io.jcurtis.kadot.engine.Kodot
import io.jcurtis.kadot.engine.io.Input
import io.jcurtis.kadot.engine.nodes.Sprite
import io.jcurtis.kadot.engine.nodes.physics.CollisionShape
import io.jcurtis.kadot.engine.nodes.physics.KinematicBody
import io.jcurtis.kadot.engine.utils.Direction
import io.jcurtis.kadot.engine.utils.Vector2
import java.awt.event.KeyEvent

class Player : KinematicBody() {
    init {
        addChild(Sprite("assets/player.png"))
        collider = CollisionShape(75, 75)
    }

    override fun update(delta: Double) {
        super.update(delta)

        if (Input.isKeyPressed(KeyEvent.VK_D)) {
            velocity.x += 1.0
        }

        if (Input.isKeyPressed(KeyEvent.VK_A)) {
            velocity.x -= 1.0
        }

        // jumping
        if (Input.isKeyPressed(KeyEvent.VK_SPACE)) {
            velocity.y -= 20.0
        }

        velocity.y += 1.0

        moveAndSlide(Direction.UP)
        velocity = Vector2(0.0, 0.0)
    }
}