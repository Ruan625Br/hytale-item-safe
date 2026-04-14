package dev.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EntityMatcher(
    @SerialName("Type") val type: String,   // Player | Vulnerable | etc.
    @SerialName("Next") val next: String? = null,
)