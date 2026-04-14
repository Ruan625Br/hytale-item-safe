package io.github.ruan625br.hytale.item.safe.dsl.builders

import io.github.ruan625br.hytale.item.safe.dsl.annotation.HytaleDsl
import io.github.ruan625br.hytale.item.safe.dsl.model.AnimationRef
import io.github.ruan625br.hytale.item.safe.dsl.model.AnimationSet

@HytaleDsl
class AnimSetBuilder {
    private val anims = mutableListOf<AnimationRef>()

    fun animation(path: String, looping: Boolean = false, weight: Float = 1f) {
        anims += AnimationRef(path, looping, weight)
    }

    internal fun build() = AnimationSet(anims)
}