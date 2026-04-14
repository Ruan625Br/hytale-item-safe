package dev.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimationSet(
    @SerialName("Animations") val animations: List<AnimationRef>,
)

@Serializable
data class AnimationRef(
    @SerialName("Animation") val animation: String,
    @SerialName("Looping") val looping: Boolean = false,
    @SerialName("Weight") val weight: Float = 1f,
)