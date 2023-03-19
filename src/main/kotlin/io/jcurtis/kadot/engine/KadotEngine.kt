package io.jcurtis.kadot.engine

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState
import io.jcurtis.kadot.engine.nodes.Node
import kotlinx.coroutines.isActive

class KadotEngine(
    private var title: String = "Kadot Engine",
    private var width: Int = 800,
    private var height: Int = 600
) {
    companion object {
        var nodes = mutableListOf<Node>()

        fun registerNode(node: Node) {
            nodes.add(node)
        }
    }

    @Composable
    fun init(applicationScope: ApplicationScope) {
        for (node in nodes) {
            node.ready()
        }

        return Window(
            onCloseRequest = { applicationScope.exitApplication() },
            title = title,
            state = rememberWindowState(width = width.dp, height = height.dp)
        ) {
            val coroutineScope = rememberCoroutineScope()

            DisposableEffect(Unit) {
                println("Starting Engine")
                val job = coroutineScope.launch {
                    while (isActive) {
                        withFrameNanos {
                            for (node in nodes) {
                                node.update()
                            }
                        }
                    }
                }
                onDispose {
                    job.cancel()
                }
            }
        }
    }
}
