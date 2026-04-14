package io.github.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class ItemInteractions(
    @SerialName("Primary") val primary: String? = null,
    @SerialName("Secondary") val secondary: String? = null,
    @SerialName("Ability1") val ability1: String? = null,
    @SerialName("Ability2") val ability2: String? = null,
    @SerialName("Ability3") val ability3: String? = null,
    @SerialName("Use") val use: InteractionChainRef? = null,
    @SerialName("SwapTo") val swapTo: InteractionChainRef? = null,
    @SerialName("SwapFrom") val swapFrom: InteractionChainRef? = null,
    @SerialName("Equipped") val equipped: InteractionChainRef? = null,
    @SerialName("Wielding") val wielding: InteractionChainRef? = null,
)

@Serializable
data class InteractionChainRef(
    @SerialName("Interactions") val interactions: List<InlineInteraction> = emptyList(),
)

@Serializable
data class InlineInteraction(
    @SerialName("Type") val type: String,
    @SerialName("Next") val next: String? = null,
    @SerialName("Failed") val failed: String? = null,
    val extras: Map<String, JsonElement> = emptyMap(),
)