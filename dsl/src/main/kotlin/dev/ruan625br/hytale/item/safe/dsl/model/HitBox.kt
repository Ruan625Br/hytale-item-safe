package dev.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HitBox(
    @SerialName("Max") val max: Vec3 = Vec3(1f, 1f, 1f),
    @SerialName("Min") val min: Vec3 = Vec3(0f, 0f, 0f),
)