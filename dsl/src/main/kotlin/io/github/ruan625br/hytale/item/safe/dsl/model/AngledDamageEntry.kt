package io.github.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AngledDamageEntry(
    @SerialName("Direction") val direction: String,
    @SerialName("Damage") val damage: Float,
)