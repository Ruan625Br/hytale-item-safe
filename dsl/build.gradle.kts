plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "2.3.20"
    id("com.vanniktech.maven.publish")
}


repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(project(":annotations"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.11.0")
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}