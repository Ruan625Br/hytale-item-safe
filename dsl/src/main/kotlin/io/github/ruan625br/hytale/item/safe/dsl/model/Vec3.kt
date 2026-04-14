package io.github.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Vec3(
    @SerialName("X") val x: Float = 0f,
    @SerialName("Y") val y: Float = 0f,
    @SerialName("Z") val z: Float = 0f,
)