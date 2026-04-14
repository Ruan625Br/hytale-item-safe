package io.github.ruan625br.hytale.item.safe.dsl.builders

import io.github.ruan625br.hytale.item.safe.dsl.annotation.HytaleDsl
import io.github.ruan625br.hytale.item.safe.dsl.model.InteractionRules


@HytaleDsl
class RulesBuilder {
    private val blockedBy = mutableListOf<String>()
    private val blocking = mutableListOf<String>()
    private val interruptedBy = mutableListOf<String>()
    private val interrupting = mutableListOf<String>()

    fun blockedBy(vararg types: String) {
        blockedBy += types
    }

    fun blocking(vararg types: String) {
        blocking += types
    }

    fun interruptedBy(vararg types: String) {
        interruptedBy += types
    }

    fun interrupting(vararg types: String) {
        interrupting += types
    }

    internal fun build() = InteractionRules(
        blockedBy = blockedBy.ifEmpty { null },
        blocking = blocking.ifEmpty { null },
        interruptedBy = interruptedBy.ifEmpty { null },
        interrupting = interrupting.ifEmpty { null },
    )
}
