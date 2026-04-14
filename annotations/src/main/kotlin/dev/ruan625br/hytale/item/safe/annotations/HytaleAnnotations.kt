package dev.ruan625br.hytale.item.safe.annotations


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class HytaleItem(
    val id: String,
    val outputPath: String = "",
)

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class HytaleModel(
    val id: String,
    val outputPath: String = "",
)

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class HytaleRootInteraction(
    val id: String,
    val outputPath: String = "",
)

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class HytaleInteraction(
    val id: String,
    val outputPath: String = "",
)