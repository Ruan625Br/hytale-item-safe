plugins {
    kotlin("jvm") version "2.3.0"
    id("com.gradle.plugin-publish") version "2.1.1" apply false
    id("com.vanniktech.maven.publish") version "0.36.0"
}

allprojects {
    group = "io.github.ruan625br.hytale.item.safe"
    version = "1.0.0"
}

subprojects {
    repositories {
        mavenCentral()
    }

    if (name != "gradle-plugin" && name != "sample") {
        apply(plugin = "com.vanniktech.maven.publish")

        mavenPublishing {
            publishToMavenCentral()
            signAllPublications()

            coordinates(
                project.group.toString(),
                project.name,
                project.version.toString(),
            )

            pom {
                name.set("hytale-item-safe - ${project.name}")
                description.set("Kotlin DSL + KSP to define Hytale type-safe items")
                url.set("https://github.com/ruan625br/hytale-item-safe")

                developers {
                    developer {
                        id.set("ruan625br")
                        name.set("Ruan625br")
                        url.set("https://github.com/ruan625br")
                    }
                }

                licenses {
                    license {
                        name.set("GNU General Public License version 3")
                        url.set("https://opensource.org/license/gpl-3.0")
                    }
                }

                scm {
                    url.set("https://github.com/ruan625br/hytale-item-safe")
                    connection.set("scm:git:git://github.com/ruan625br/hytale-item-safe.git")
                    developerConnection.set("scm:git:ssh://git@github.com/ruan625br/hytale-item-safe.git")
                }
            }

        }

        configure<SigningExtension> {
            useGpgCmd()
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}
