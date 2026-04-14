package io.github.ruan625br.hytale.item.safe.dsl.model

import io.github.ruan625br.hytale.item.safe.dsl.definition.ResourceDefinition
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InteractionDefinition(
    @SerialName("Type") val type: String,
    @SerialName("Next") val next: String? = null,
    @SerialName("Failed") val failed: String? = null,

    @SerialName("RunTime") val runTime: Float? = null,
    @SerialName("HorizontalSpeedMultiplier") val speedMultiplier: Float? = null,
    @SerialName("CancelOnItemChange") val cancelOnItemChange: Boolean? = null,
    @SerialName("ViewDistance") val viewDistance: Double? = null,

    @SerialName("Effects") val effects: InteractionEffects? = null,

    @SerialName("Rules") val rules: InteractionRules? = null,

    @SerialName("DamageCalculatorType") val damageCalcType: String? = null,
    @SerialName("Damage") val damage: Float? = null,
    @SerialName("DamageClass") val damageClass: String? = null,
    @SerialName("Knockback") val knockback: KnockbackConfig? = null,
    @SerialName("Blocked") val blocked: String? = null,
    @SerialName("AngledDamage") val angledDamage: List<AngledDamageEntry>? = null,

    @SerialName("AllowIndefiniteHold") val allowIndefiniteHold: Boolean? = null,
    @SerialName("MaxDuration") val maxDuration: Float? = null,
    @SerialName("DisplayProgress") val displayProgress: Boolean? = null,

    @SerialName("ChainId") val chainId: String? = null,
    @SerialName("ChainingAllowance") val chainingAllowance: Float? = null,

    @SerialName("Radius") val radius: Float? = null,
    @SerialName("FailOn") val failOn: String? = null,
    @SerialName("MaxHits") val maxHits: Int? = null,
    @SerialName("Matchers") val matchers: List<EntityMatcher>? = null,

    @SerialName("GameMode") val gameMode: String? = null,
    @SerialName("Jumping") val jumping: Boolean? = null,
    @SerialName("Crouching") val crouching: Boolean? = null,
    @SerialName("Running") val running: Boolean? = null,
    @SerialName("Flying") val flying: Boolean? = null,

    @SerialName("Stat") val stat: String? = null,
    @SerialName("Value") val value: Float? = null,
    @SerialName("ValueType") val valueType: String? = null,   // Absolute | Percent
    @SerialName("Behaviour") val behaviour: String? = null,   // Add | Set
    @SerialName("Target") val target: String? = null,      // User | Owner | Target

    @SerialName("ItemToAdd") val itemToAdd: InventoryItemRef? = null,
    @SerialName("ItemToRemove") val itemToRemove: InventoryItemRef? = null,
    @SerialName("AdjustHeldItemQuantity") val adjustHeldQty: Int? = null,
    @SerialName("AdjustHeldItemDurability") val adjustHeldDurability: Int? = null,
    @SerialName("BrokenItem") val brokenItem: String? = null,
    @SerialName("NotifyOnBreak") val notifyOnBreak: Boolean? = null,

    @SerialName("BlockTypeToPlace") val blockTypeToPlace: String? = null,
    @SerialName("AllowDragPlacement") val allowDragPlacement: Boolean? = null,
    @SerialName("Harvest") val harvest: Boolean? = null,


    @SerialName("EffectId") val effectId: String? = null,
    @SerialName("Duration") val duration: Float? = null,

    @SerialName("Key") val key: String? = null,

    @SerialName("Config") val projectileConfig: String? = null,

    @SerialName("MaxCount") val maxCount: Int? = null,
    @SerialName("RootInteraction") val rootInteraction: String? = null,

    @SerialName("CooldownKey") val cooldownKey: String? = null,

    @SerialName("Interactions") val interactions: List<String>? = null,
): ResourceDefinition