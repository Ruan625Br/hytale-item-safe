package io.github.ruan625br.hytale.item.safe.dsl.model

import io.github.ruan625br.hytale.item.safe.dsl.definition.ResourceDefinition
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemDefinition(
    @SerialName("TranslationProperties") val translation: TranslationProps? = null,
    @SerialName("Icon") val icon: String? = null,
    @SerialName("Categories") val categories: List<String> = emptyList(),
    @SerialName("Interactions") val interactions: ItemInteractions? = null,
    @SerialName("BlockType") val blockType: BlockTypeDefinition? = null,
    @SerialName("IconProperties") val iconProperties: IconProperties? = null,
    @SerialName("PlayerAnimationsId") val playerAnimationsId: String? = null,
    @SerialName("Tags") val tags: Map<String, List<String>> = emptyMap(),
    @SerialName("ItemSoundSetId") val soundSetId: String? = null,
    @SerialName("MaxDurability") val maxDurability: Int? = null,
    @SerialName("MaxStack") val maxStack: Int? = null,
    @SerialName("Rarity") val rarity: String? = null,
): ResourceDefinition