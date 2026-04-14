package io.github.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KnockbackConfig(
    @SerialName("Type") val type: String,             // Force | Point | Directional
    @SerialName("Direction") val direction: String? = null,
    @SerialName("Force") val force: Float? = null,
    @SerialName("VelocityY") val velocityY: Float? = null,
)