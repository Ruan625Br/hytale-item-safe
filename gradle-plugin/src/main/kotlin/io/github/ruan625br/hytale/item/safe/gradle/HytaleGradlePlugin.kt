package io.github.ruan625br.hytale.item.safe.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.JavaExec

class HytaleGradlePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val ext = project.extensions.create(
            "hytaleAssets",
            HytaleExtension::class.java,
            project
        )

        project.tasks.register("generateHytaleJson", JavaExec::class.java) {
            group = "hytale"
            description = "Serializa definições @HytaleItem/@HytaleModel para JSON"

            dependsOn("compileKotlin")

            classpath = project.files(
                project.tasks.named("compileKotlin").get().outputs.files,
                project.configurations.getByName("runtimeClasspath")
            )

            mainClass.set(ext.runnerMainClass)

            args(ext.resourcesDir.get().asFile.absolutePath)
            inputs.files(
                project.fileTree(project.projectDir) {
                    include("src/main/kotlin/**/*.kt")
                }
            )
            outputs.dir(
                ext.resourcesDir.map { it.dir("Server") }
            )

            doFirst {
                project.logger.lifecycle("[Hytale] Running HytaleRunner in ${ext.resourcesDir.get().asFile}")
            }
        }

        project.tasks.named("processResources") {
            dependsOn("generateHytaleJson")
        }
    }
}