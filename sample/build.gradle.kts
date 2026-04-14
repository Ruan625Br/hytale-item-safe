plugins {
    kotlin("jvm")
    id("io.github.ruan625br.hytale.item.safe")
    id("com.google.devtools.ksp") version "2.3.6"
    kotlin("plugin.serialization") version "2.3.20"
}

group = "io.github.ruan625br.hytale.item.safe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation(project(":annotations"))
    implementation(project(":dsl"))
    ksp(project(":ksp-processor"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.11.0")

}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}
hytaleAssets {
    resourcesDir = layout.projectDirectory.dir("src/main/resources")
}

ksp {
    arg("hytale.common.dir",
        layout.projectDirectory.dir("src/main/resources/Common").asFile.absolutePath)
    arg("hytale.server.dir",
        layout.projectDirectory.dir("src/main/resources/Server").asFile.absolutePath)

}