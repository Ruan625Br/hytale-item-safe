package ksp.processor

data class AnnotatedItem(
    val qualifiedName: String,
    val id: String,
    val outputPath: String,
    val annotationType: String,
)