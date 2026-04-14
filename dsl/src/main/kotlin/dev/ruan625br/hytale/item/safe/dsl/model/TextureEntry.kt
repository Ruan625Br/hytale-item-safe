package dev.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TextureEntry(
    @SerialName("Texture") val texture: String,
    @SerialName("Weight")  val weight: Int = 1,
    @SerialName("State")   val state: String? = null,
)