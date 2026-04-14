plugins {
    `kotlin-dsl`
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "2.1.1"
}

group = "io.github.ruan625br.hytale.item.safe"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}

gradlePlugin {
    website = "https://github.com/ruan625br/hytale-item-safe"
    vcsUrl = "https://github.com/ruan625br/hytale-item-safe.git"

    plugins {
        create("hytaleAssets") {
            id = "io.github.ruan625br.hytale.item.safe"
            displayName = "Hytale Item Safe"
            description = "Type-safe Kotlin DSL for Hytale assets"
            tags = listOf("hytale", "dsl", "kotlin", "assets")

            implementationClass = "io.github.ruan625br.hytale.item.safe.gradle.HytaleGradlePlugin"
        }
    }
}
