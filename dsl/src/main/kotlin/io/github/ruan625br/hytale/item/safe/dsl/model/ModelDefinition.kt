package io.github.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ModelDefinition(
    @SerialName("Model") val model: String,
    @SerialName("Texture") val texture: String,
    @SerialName("HitBox") val hitBox: HitBox = HitBox(),
    @SerialName("MinScale") val minScale: Float = 1f,
    @SerialName("MaxScale") val maxScale: Float = 1f,
    @SerialName("AnimationSets") val animationSets: Map<String, AnimationSet> = emptyMap(),
    @SerialName("NetworkId") val networkId: String? = null,
)