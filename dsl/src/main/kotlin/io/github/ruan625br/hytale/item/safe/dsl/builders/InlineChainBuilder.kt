package io.github.ruan625br.hytale.item.safe.dsl.builders

import io.github.ruan625br.hytale.item.safe.dsl.annotation.HytaleDsl
import io.github.ruan625br.hytale.item.safe.dsl.model.InlineInteraction
import io.github.ruan625br.hytale.item.safe.dsl.model.InteractionChainRef
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive

@HytaleDsl
class InlineChainBuilder {
    private val interactions = mutableListOf<InlineInteraction>()

    fun interaction(
        type: String, next: String? = null, failed: String? = null,
        extras: Map<String, String> = emptyMap()
    ) {
        val jsonExtras = extras.mapValues { JsonPrimitive(it.value) as JsonElement }
        interactions += InlineInteraction(type, next, failed, jsonExtras)
    }

    fun modifyInventory(itemId: String, qty: Int = 1, action: String = "Add") =
        interaction(
            "ModifyInventory", extras = mapOf(
                "Action" to action, "ItemId" to itemId, "Quantity" to qty.toString()
            )
        )

    internal fun build() = InteractionChainRef(interactions)
}