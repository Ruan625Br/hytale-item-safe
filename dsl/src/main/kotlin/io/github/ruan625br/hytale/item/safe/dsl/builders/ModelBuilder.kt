package io.github.ruan625br.hytale.item.safe.dsl.builders

import io.github.ruan625br.hytale.item.safe.dsl.annotation.HytaleDsl
import io.github.ruan625br.hytale.item.safe.dsl.model.AnimationSet
import io.github.ruan625br.hytale.item.safe.dsl.model.HitBox
import io.github.ruan625br.hytale.item.safe.dsl.model.ModelDefinition
import io.github.ruan625br.hytale.item.safe.dsl.model.Vec3

@HytaleDsl
class ModelBuilder {
    var model: String = ""
    var texture: String = ""
    var minScale: Float = 1f
    var maxScale: Float = 1f
    var networkId: String? = null
    private var hitBox: HitBox = HitBox()
    private val animSets = mutableMapOf<String, AnimationSet>()

    fun hitBox(
        maxX: Float = 1f, maxY: Float = 1f, maxZ: Float = 1f,
        minX: Float = 0f, minY: Float = 0f, minZ: Float = 0f,
    ) {
        hitBox = HitBox(Vec3(maxX, maxY, maxZ), Vec3(minX, minY, minZ))
    }

    fun animationSet(name: String, block: AnimSetBuilder.() -> Unit) {
        animSets[name] = AnimSetBuilder().apply(block).build()
    }

    internal fun build() = ModelDefinition(
        model = model,
        texture = texture,
        hitBox = hitBox,
        minScale = minScale,
        maxScale = maxScale,
        animationSets = animSets,
        networkId = networkId,
    )
}

fun hytaleModel(block: ModelBuilder.() -> Unit): ModelDefinition =
    ModelBuilder().apply(block).build()