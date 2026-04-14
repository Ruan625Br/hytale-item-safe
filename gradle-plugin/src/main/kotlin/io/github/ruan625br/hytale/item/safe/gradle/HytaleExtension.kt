package io.github.ruan625br.hytale.item.safe.gradle

import org.gradle.api.Project
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property

abstract class HytaleExtension(project: Project) {
    val resourcesDir: DirectoryProperty =
        project.objects.directoryProperty().convention(
            project.layout.projectDirectory.dir("src/main/resources")
        )
    val runnerMainClass: Property<String> =
        project.objects.property(String::class.java).convention(
            "io.github.ruan625br.hytale.item.safe.generated.HytaleRunnerKt"
        )
}