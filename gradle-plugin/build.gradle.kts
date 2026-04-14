plugins {
    `kotlin-dsl`
    id("java-gradle-plugin")
    id("maven-publish")
}

group = "dev.ruan625br.hytale.item.safe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}

gradlePlugin {
    plugins {
        create("hytaleAssets") {
            id = "dev.ruan625br.hytale.item.safe"
            implementationClass = "dev.ruan625br.hytale.item.safe.gradle.HytaleGradlePlugin"
        }
    }
}
