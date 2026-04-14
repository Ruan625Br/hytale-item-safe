package io.github.ruan625br.hytale.item.safe.dsl.builders

import io.github.ruan625br.hytale.item.safe.dsl.annotation.HytaleDsl
import io.github.ruan625br.hytale.item.safe.dsl.model.InteractionChainRef
import io.github.ruan625br.hytale.item.safe.dsl.model.ItemInteractions

@HytaleDsl
class ItemInteractionsBuilder {
    private var primary: String? = null
    private var secondary: String? = null
    private var ability1: String? = null
    private var ability2: String? = null
    private var ability3: String? = null
    private var use: InteractionChainRef? = null
    private var swapTo: InteractionChainRef? = null
    private var swapFrom: InteractionChainRef? = null
    private var equipped: InteractionChainRef? = null
    private var wielding: InteractionChainRef? = null


    fun primary(rootInteractionId: String) {
        primary = rootInteractionId
    }

    fun secondary(rootInteractionId: String) {
        secondary = rootInteractionId
    }

    fun ability1(rootInteractionId: String) {
        ability1 = rootInteractionId
    }

    fun ability2(rootInteractionId: String) {
        ability2 = rootInteractionId
    }

    fun ability3(rootInteractionId: String) {
        ability3 = rootInteractionId
    }

    fun use(block: InlineChainBuilder.() -> Unit) {
        use = InlineChainBuilder().apply(block).build()
    }

    fun swapTo(block: InlineChainBuilder.() -> Unit) {
        swapTo = InlineChainBuilder().apply(block).build()
    }

    fun swapFrom(block: InlineChainBuilder.() -> Unit) {
        swapFrom = InlineChainBuilder().apply(block).build()
    }

    fun equipped(block: InlineChainBuilder.() -> Unit) {
        equipped = InlineChainBuilder().apply(block).build()
    }

    fun wielding(block: InlineChainBuilder.() -> Unit) {
        wielding = InlineChainBuilder().apply(block).build()
    }

    internal fun build() = ItemInteractions(
        primary, secondary, ability1, ability2, ability3,
        use, swapTo, swapFrom, equipped, wielding,
    )
}