package dev.ruan625br.hytale.item.safe.dsl.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InteractionEffects(
    @SerialName("WorldSoundEventId") val worldSound: String? = null,
    @SerialName("LocalSoundEventId") val localSound: String? = null,
    @SerialName("ItemPlayerAnimationsId") val playerAnim: String? = null,
    @SerialName("ItemAnimationId") val itemAnim: String? = null,
    @SerialName("WaitForAnimationToFinish") val waitForAnim: Boolean? = null,
    @SerialName("ClearAnimationOnFinish") val clearAnimOnFinish: Boolean? = null,
    @SerialName("ClearSoundEventOnFinish") val clearSoundOnFinish: Boolean? = null,
    @SerialName("StartDelay") val startDelay: Float? = null,
    @SerialName("Particles") val particles: List<String>? = null,
    @SerialName("CameraEffect") val cameraEffect: String? = null,
)