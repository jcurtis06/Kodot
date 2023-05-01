package io.jcurtis.kadot.engine.nodes.physics

import io.jcurtis.kadot.engine.Kodot
import io.jcurtis.kadot.engine.nodes.NodeType
import io.jcurtis.kadot.engine.utils.Direction
import io.jcurtis.kadot.engine.utils.Vector2
import java.awt.Rectangle
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

@Suppress("unused")
open class KinematicBody : CollisionBody(NodeType.KINEMATIC_BODY, "KinematicBody") {
    private var collidingX = false
    private var collidingY = false

    var collidedDirection: Direction = Direction.NONE

    var velocity = Vector2(0.0, 0.0)
    private var physicsEnabled = true

    private fun applyVelocity(upwards: Direction) {
        if (velocity.x > 0) {
            // right
            for (i in 0..velocity.x.roundToInt()) {
                val cs: CollisionBody? = checkCollisionsAt(Vector2(this.position.x + 1, this.position.y))
                if (cs != null) {
                    collidingX = true
                    onCollision(cs, Direction.RIGHT)
                    return
                }
                collidingX = false
                this.position.x += 1
            }
        }

        if (velocity.x < 0) {
            // left
            for (i in 0..velocity.x.absoluteValue.roundToInt()) {
                val cs: CollisionBody? = checkCollisionsAt(Vector2(this.position.x - 1, this.position.y))
                if (cs != null) {
                    collidingX = true
                    onCollision(cs, Direction.LEFT)
                    return
                }
                collidingX = false
                this.position.x -= 1
            }
        }

        if (velocity.y > 0) {
            // down
            for (i in 0..velocity.y.toInt()) {
                val cs: CollisionBody? = checkCollisionsAt(Vector2(this.position.x, this.position.y + 1))
                if (cs != null) {
                    collidingY = true
                    onCollision(cs, Direction.DOWN)
                    return
                }
                collidingY = false
                this.position.y += 1
            }
        }

        if (velocity.y < 0) {
            // up
            for (i in 0..velocity.y.toInt()) {
                val cs: CollisionBody? = checkCollisionsAt(Vector2(this.position.x, this.position.y - 1))
                if (cs != null) {
                    collidingY = true
                    onCollision(cs, Direction.UP)
                    return
                }
                collidingY = false
                this.position.y -= 1
            }
        }

        collidedDirection = Direction.NONE
    }

    private fun checkCollisions(newPos: Vector2): Boolean {
        if (!physicsEnabled) return false
        if (collider == null) return false

        val cs: CollisionBody? = checkCollisionsAt(newPos)
        return cs != null
    }

    private fun checkCollisionsAt(newPos: Vector2): CollisionBody? {
        val future = Rectangle(newPos.x.toInt(), newPos.y.toInt(), collider!!.width, collider!!.height)

        for (body in Kodot.colliderNodes) {
            if (body == this) continue
            if (body.collider == null) continue

            if (body.collider!!.getBounds().intersects(future)) {
                if (!mask.contains(body.layer)) continue
                return body
            }
        }
        return null
    }

    fun moveAndSlide(upwards: Direction = Direction.UP) {
        applyVelocity(upwards)

        if (collidingX) {
            velocity = Vector2(0.0, velocity.y)
        } else if (collidingY) {
            velocity = Vector2(velocity.x, 0.0)
        }
    }

    open fun onCollision(body: CollisionBody, direction: Direction) {
        collidedDirection = direction
    }
}