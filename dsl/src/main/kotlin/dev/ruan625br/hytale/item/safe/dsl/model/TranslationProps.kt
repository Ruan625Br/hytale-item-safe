package dev.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TranslationProps(
    @SerialName("Name") val name: String,
    @SerialName("Description") val description: String? = null,
)