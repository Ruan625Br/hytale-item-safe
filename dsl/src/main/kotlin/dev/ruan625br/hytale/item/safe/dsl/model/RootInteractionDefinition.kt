package dev.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RootInteractionDefinition(
    @SerialName("Interactions") val interactions: List<String>,
    @SerialName("RequireNewClick") val requireNewClick: Boolean = false,
    @SerialName("InteractionType") val interactionType: String? = null,
    @SerialName("Cooldown") val cooldown: CooldownConfig? = null,
    @SerialName("CancelOnOtherClick") val cancelOnOtherClick: Boolean? = null,
)