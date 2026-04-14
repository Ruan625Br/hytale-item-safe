package dev.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InventoryItemRef(
    @SerialName("ItemId") val itemId: String,
    @SerialName("Quantity") val quantity: Int = 1,
)
