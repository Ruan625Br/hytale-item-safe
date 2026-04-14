package io.github.ruan625br.hytale.item.safe.dsl.builders

import io.github.ruan625br.hytale.item.safe.dsl.annotation.HytaleDsl
import io.github.ruan625br.hytale.item.safe.dsl.model.InteractionEffects

@HytaleDsl
class EffectsBuilder {
    var worldSound: String? = null
    var localSound: String? = null
    var playerAnim: String? = null
    var itemAnim: String? = null
    var waitForAnim: Boolean? = null
    var clearAnimOnFinish: Boolean? = null
    var clearSoundOnFinish: Boolean? = null
    var startDelay: Float? = null
    var cameraEffect: String? = null
    private val particles = mutableListOf<String>()

    fun particle(id: String) {
        particles += id
    }

    internal fun build() = InteractionEffects(
        worldSound = worldSound,
        localSound = localSound,
        playerAnim = playerAnim,
        itemAnim = itemAnim,
        waitForAnim = waitForAnim,
        clearAnimOnFinish = clearAnimOnFinish,
        clearSoundOnFinish = clearSoundOnFinish,
        startDelay = startDelay,
        particles = particles.ifEmpty { null },
        cameraEffect = cameraEffect,
    )
}