package io.github.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class BlockTypeDefinition(
    @SerialName("Material") val material: String,
    @SerialName("DrawType") val drawType: String,
    @SerialName("Group") val group: String,
    @SerialName("Flags") val flags: Map<String, Boolean> = emptyMap(),
    @SerialName("Gathering") val gathering: GatheringConfig? = null,
    @SerialName("BlockParticleSetId") val particleSetId: String? = null,
    @SerialName("CustomModel") val customModel: String? = null,
    @SerialName("CustomModelTexture") val textures: List<TextureEntry> = emptyList(),
    @SerialName("BlockSoundSetId") val soundSetId: String? = null,
    @SerialName("ParticleColor") val particleColor: String? = null,
    @SerialName("LightLevel") val lightLevel: Int? = null,
    @SerialName("HardnessModifier") val hardnessModifier: Float? = null,
    @SerialName("PlacementConditions") val placementConditions: List<String> = emptyList(),
)