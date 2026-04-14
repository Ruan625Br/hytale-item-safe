plugins {
    kotlin("jvm")
}

group = "dev.ruan625br.hytale.item.safe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(project(":annotations"))
    implementation("com.google.devtools.ksp:symbol-processing-api:2.1.0-1.0.29")

}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}