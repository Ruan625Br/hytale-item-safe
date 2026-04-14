package dev.ruan625br.hytale.item.safe.dsl.builders

import dev.ruan625br.hytale.item.safe.dsl.annotation.HytaleDsl
import dev.ruan625br.hytale.item.safe.dsl.model.BlockTypeDefinition
import dev.ruan625br.hytale.item.safe.dsl.model.BreakingConfig
import dev.ruan625br.hytale.item.safe.dsl.model.GatheringConfig
import dev.ruan625br.hytale.item.safe.dsl.model.TextureEntry

@HytaleDsl
class BlockTypeBuilder {
    var material: String = "Solid"
    var drawType: String = "Normal"
    var group: String = "Stone"
    var particleSetId: String? = null
    var customModel: String? = null
    var soundSetId: String? = null
    var particleColor: String? = null
    var lightLevel: Int? = null
    var hardnessModifier: Float? = null
    private val textures = mutableListOf<TextureEntry>()
    private val flags = mutableMapOf<String, Boolean>()
    private var gathering: GatheringConfig? = null
    private val placementConditions = mutableListOf<String>()

    fun texture(path: String, weight: Int = 1, state: String? = null) {
        textures += TextureEntry(path, weight, state)
    }

    fun flag(name: String, value: Boolean = true) { flags[name] = value }

    fun gathering(
        gatherType: String,
        toolType: String? = null,
        toolTier: Int? = null,
    ) {
        gathering = GatheringConfig(BreakingConfig(gatherType, toolType, toolTier))
    }

    fun placementCondition(condition: String) { placementConditions += condition }

    internal fun build() = BlockTypeDefinition(
        material = material,
        drawType = drawType,
        group = group,
        flags = flags,
        gathering = gathering,
        particleSetId = particleSetId,
        customModel = customModel,
        textures = textures,
        soundSetId = soundSetId,
        particleColor = particleColor,
        lightLevel = lightLevel,
        hardnessModifier = hardnessModifier,
        placementConditions = placementConditions,
    )
}