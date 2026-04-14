pluginManagement {
    includeBuild("gradle-plugin")
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
rootProject.name = "hytale-item-safe"
include("annotations")
include("dsl")
include("ksp-processor")
include("sample")

