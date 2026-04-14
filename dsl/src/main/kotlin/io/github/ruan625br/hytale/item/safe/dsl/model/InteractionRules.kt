package io.github.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InteractionRules(
    @SerialName("BlockedBy") val blockedBy: List<String>? = null,
    @SerialName("Blocking") val blocking: List<String>? = null,
    @SerialName("InterruptedBy") val interruptedBy: List<String>? = null,
    @SerialName("Interrupting") val interrupting: List<String>? = null,
)