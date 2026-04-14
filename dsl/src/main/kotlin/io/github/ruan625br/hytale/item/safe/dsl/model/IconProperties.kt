package io.github.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IconProperties(
    @SerialName("Scale") val scale: Double,
    @SerialName("Translation") val translation: List<Double> = emptyList(),
    @SerialName("Rotation") val rotation: List<Double> = emptyList(),
)