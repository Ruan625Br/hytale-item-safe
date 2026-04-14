package io.github.ruan625br.hytale.item.safe.dsl.builders

import io.github.ruan625br.hytale.item.safe.dsl.annotation.HytaleDsl
import io.github.ruan625br.hytale.item.safe.dsl.model.AngledDamageEntry
import io.github.ruan625br.hytale.item.safe.dsl.model.EntityMatcher
import io.github.ruan625br.hytale.item.safe.dsl.model.InteractionDefinition
import io.github.ruan625br.hytale.item.safe.dsl.model.InteractionEffects
import io.github.ruan625br.hytale.item.safe.dsl.model.InteractionRules
import io.github.ruan625br.hytale.item.safe.dsl.model.InventoryItemRef
import io.github.ruan625br.hytale.item.safe.dsl.model.KnockbackConfig

@HytaleDsl
class InteractionBuilder {
    var type: String = ""

    var next: String? = null
    var failed: String? = null

    var runTime: Float? = null
    var speedMultiplier: Float? = null
    var cancelOnItemChange: Boolean? = null
    var viewDistance: Double? = null

    private var effects: InteractionEffects? = null

    fun effects(block: EffectsBuilder.() -> Unit) {
        effects = EffectsBuilder().apply(block).build()
    }

    private var rules: InteractionRules? = null

    fun rules(block: RulesBuilder.() -> Unit) {
        rules = RulesBuilder().apply(block).build()
    }

    var damageCalcType: String? = null   // "Absolute" | "Dps"
    var damage: Float? = null
    var damageClass: String? = null      // "Unknown" | "Light" | "Charged" | "Signature"
    var blocked: String? = null
    private var knockback: KnockbackConfig? = null
    private val angledDamage = mutableListOf<AngledDamageEntry>()

    fun knockback(
        type: String, direction: String? = null, force: Float? = null,
        velocityY: Float? = null
    ) {
        knockback = KnockbackConfig(type, direction, force, velocityY)
    }

    fun angledDamage(direction: String, damage: Float) {
        angledDamage += AngledDamageEntry(direction, damage)
    }

    var allowIndefiniteHold: Boolean? = null
    var maxDuration: Float? = null
    var displayProgress: Boolean? = null

    var chainId: String? = null
    var chainingAllowance: Float? = null

    var radius: Float? = null
    var failOn: String? = null
    var maxHits: Int? = null
    private val matchers = mutableListOf<EntityMatcher>()

    fun matcher(entityType: String, next: String? = null) {
        matchers += EntityMatcher(entityType, next)
    }

    var gameMode: String? = null
    var jumping: Boolean? = null
    var crouching: Boolean? = null
    var running: Boolean? = null
    var flying: Boolean? = null

    var stat: String? = null
    var value: Float? = null
    var valueType: String? = null   // "Absolute" | "Percent"
    var behaviour: String? = null   // "Add" | "Set"
    var target: String? = null      // "User" | "Owner" | "Target"

    private var itemToAdd: InventoryItemRef? = null
    private var itemToRemove: InventoryItemRef? = null
    var adjustHeldQty: Int? = null
    var adjustHeldDurability: Int? = null
    var brokenItem: String? = null
    var notifyOnBreak: Boolean? = null

    fun addItem(itemId: String, quantity: Int = 1) {
        itemToAdd = InventoryItemRef(itemId, quantity)
    }

    fun removeItem(itemId: String, quantity: Int = 1) {
        itemToRemove = InventoryItemRef(itemId, quantity)
    }

    var blockTypeToPlace: String? = null
    var allowDragPlacement: Boolean? = null
    var harvest: Boolean? = null

    var effectId: String? = null
    var duration: Float? = null

    var key: String? = null

    var projectileConfig: String? = null

    var maxCount: Int? = null
    var rootInteraction: String? = null

    var cooldownKey: String? = null

    private val childInteractions = mutableListOf<String>()

    fun child(id: String) {
        childInteractions += id
    }

    fun absoluteDamage(amount: Float, damageClass: String = "Light") {
        type = "DamageEntity"
        damageCalcType = "Absolute"
        damage = amount
        this.damageClass = damageClass
    }

    fun dpsDamage(dps: Float, duration: Float, damageClass: String = "Light") {
        type = "DamageEntity"
        damageCalcType = "Dps"
        damage = dps
        runTime = duration
        this.damageClass = damageClass
    }

    fun delay(seconds: Float) {
        type = "Simple"
        runTime = seconds
    }

    fun addStat(statName: String, amount: Float, targetEntity: String = "User") {
        type = "ChangeStat"
        stat = statName
        value = amount
        valueType = "Absolute"
        behaviour = "Add"
        target = targetEntity
    }

    internal fun build() = InteractionDefinition(
        type = type,
        next = next,
        failed = failed,
        runTime = runTime,
        speedMultiplier = speedMultiplier,
        cancelOnItemChange = cancelOnItemChange,
        viewDistance = viewDistance,
        effects = effects,
        rules = rules,
        damageCalcType = damageCalcType,
        damage = damage,
        damageClass = damageClass,
        knockback = knockback,
        blocked = blocked,
        angledDamage = angledDamage.ifEmpty { null },
        allowIndefiniteHold = allowIndefiniteHold,
        maxDuration = maxDuration,
        displayProgress = displayProgress,
        chainId = chainId,
        chainingAllowance = chainingAllowance,
        radius = radius,
        failOn = failOn,
        maxHits = maxHits,
        matchers = matchers.ifEmpty { null },
        gameMode = gameMode,
        jumping = jumping,
        crouching = crouching,
        running = running,
        flying = flying,
        stat = stat,
        value = value,
        valueType = valueType,
        behaviour = behaviour,
        target = target,
        itemToAdd = itemToAdd,
        itemToRemove = itemToRemove,
        adjustHeldQty = adjustHeldQty,
        adjustHeldDurability = adjustHeldDurability,
        brokenItem = brokenItem,
        notifyOnBreak = notifyOnBreak,
        blockTypeToPlace = blockTypeToPlace,
        allowDragPlacement = allowDragPlacement,
        harvest = harvest,
        effectId = effectId,
        duration = duration,
        key = key,
        projectileConfig = projectileConfig,
        maxCount = maxCount,
        rootInteraction = rootInteraction,
        cooldownKey = cooldownKey,
        interactions = childInteractions.ifEmpty { null },
    )
}

fun hytaleInteraction(block: InteractionBuilder.() -> Unit): InteractionDefinition =
    InteractionBuilder().apply(block).build()