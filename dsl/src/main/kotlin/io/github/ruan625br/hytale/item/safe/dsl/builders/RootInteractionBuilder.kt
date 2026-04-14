package io.github.ruan625br.hytale.item.safe.dsl.builders

import io.github.ruan625br.hytale.item.safe.dsl.annotation.HytaleDsl
import io.github.ruan625br.hytale.item.safe.dsl.model.CooldownConfig
import io.github.ruan625br.hytale.item.safe.dsl.model.RootInteractionDefinition


@HytaleDsl
class RootInteractionBuilder {
    private val interactions = mutableListOf<String>()
    var requireNewClick: Boolean = false
    var interactionType: String? = null
    var cooldown: CooldownConfig? = null
    var cancelOnOtherClick: Boolean? = null

    fun interaction(id: String) {
        interactions += id
    }

    fun cooldown(duration: Float, charges: Int = 1, clickBypass: Boolean = false) {
        cooldown = CooldownConfig(duration, charges, clickBypass)
    }

    internal fun build() = RootInteractionDefinition(
        interactions = interactions,
        requireNewClick = requireNewClick,
        interactionType = interactionType,
        cooldown = cooldown,
        cancelOnOtherClick = cancelOnOtherClick,
    )
}

fun hytaleRootInteraction(block: RootInteractionBuilder.() -> Unit): RootInteractionDefinition =
    RootInteractionBuilder().apply(block).build()