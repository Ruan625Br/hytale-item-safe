package io.github.ruan625br.hytale.item.safe.dsl.builders

import io.github.ruan625br.hytale.item.safe.dsl.annotation.HytaleDsl
import io.github.ruan625br.hytale.item.safe.dsl.model.BlockTypeDefinition
import io.github.ruan625br.hytale.item.safe.dsl.model.IconProperties
import io.github.ruan625br.hytale.item.safe.dsl.model.ItemDefinition
import io.github.ruan625br.hytale.item.safe.dsl.model.ItemInteractions
import io.github.ruan625br.hytale.item.safe.dsl.model.TranslationProps

@HytaleDsl
class ItemBuilder {
    private var translation: TranslationProps? = null
    private var icon: String? = null
    private val categories = mutableListOf<String>()
    private var interactions: ItemInteractions? = null
    private var blockType: BlockTypeDefinition? = null
    private var iconProps: IconProperties? = null
    private var playerAnimId: String? = null
    private val tags = mutableMapOf<String, MutableList<String>>()
    private var soundSetId: String? = null
    private var maxDurability: Int? = null
    private var maxStack: Int? = null
    private var rarity: String? = null

    fun name(value: String) { translation = TranslationProps(value) }
    fun name(value: String, description: String) {
        translation = TranslationProps(value, description)
    }

    fun icon(path: String) { icon = path }
    fun category(vararg cats: String) { categories += cats }
    fun playerAnimation(id: String) { playerAnimId = id }
    fun soundSet(id: String) { soundSetId = id }
    fun maxDurability(value: Int) { maxDurability = value }
    fun maxStack(value: Int) { maxStack = value }
    fun rarity(value: String) { rarity = value }

    fun tag(key: String, vararg values: String) {
        tags.getOrPut(key) { mutableListOf() } += values
    }

    fun iconProperties(
        scale: Double,
        tx: Double = 0.0, ty: Double = 0.0,
        rx: Double = 0.0, ry: Double = 0.0, rz: Double = 0.0,
    ) {
        iconProps = IconProperties(scale, listOf(tx, ty), listOf(rx, ry, rz))
    }

    fun interactions(block: ItemInteractionsBuilder.() -> Unit) {
        interactions = ItemInteractionsBuilder().apply(block).build()
    }

    fun blockType(block: BlockTypeBuilder.() -> Unit) {
        blockType = BlockTypeBuilder().apply(block).build()
    }
    internal fun build() = ItemDefinition(
        translation = translation,
        icon = icon,
        categories = categories,
        interactions = interactions,
        blockType = blockType,
        iconProperties = iconProps,
        playerAnimationsId = playerAnimId,
        tags = tags.mapValues { it.value.toList() },
        soundSetId = soundSetId,
        maxDurability = maxDurability,
        maxStack = maxStack,
        rarity = rarity,
    )
}

fun hytaleItem(block: ItemBuilder.() -> Unit): ItemDefinition =
    ItemBuilder().apply(block).build()