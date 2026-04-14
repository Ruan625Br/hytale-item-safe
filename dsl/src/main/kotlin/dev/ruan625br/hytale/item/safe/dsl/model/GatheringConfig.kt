package dev.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GatheringConfig(
    @SerialName("Breaking") val breaking: BreakingConfig? = null,
)

@kotlinx.serialization.Serializable
data class BreakingConfig(
    @SerialName("GatherType") val gatherType: String,
    @SerialName("ToolType") val toolType: String? = null,
    @SerialName("ToolTier") val toolTier: Int? = null,
)