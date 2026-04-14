package io.github.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CooldownConfig(
    @SerialName("Duration") val duration: Float,
    @SerialName("Charges") val charges: Int = 1,
    @SerialName("ClickBypass") val clickBypass: Boolean = false,
)