plugins {
    kotlin("jvm")
}

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