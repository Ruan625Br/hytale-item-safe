package ksp.runner

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl.PACKAGE_NAME
import ksp.processor.AnnotatedItem

class HytaleRunner(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger,) {

    fun generateRunner(items: List<AnnotatedItem>) {
        val file = codeGenerator.createNewFile(
            dependencies = Dependencies(aggregating = true),
            packageName = "io.github.ruan625br.hytale.item.safe.generated",
            fileName = "HytaleRunner"
        )

        file.bufferedWriter().use { w ->
            w.appendLine("// AUTO-GENERATED — do not edit manually")
            w.appendLine("package io.github.ruan625br.hytale.item.safe.generated")
            w.appendLine()
            w.appendLine("import kotlinx.serialization.encodeToString")
            w.appendLine("import kotlinx.serialization.json.Json")
            w.appendLine("import java.io.File")
            w.appendLine()
            w.appendLine("private val json = Json {")
            w.appendLine("    prettyPrint = true")
            w.appendLine("    encodeDefaults = false")
            w.appendLine("    explicitNulls = false")
            w.appendLine("}")
            w.appendLine()
            w.appendLine("fun main(args: Array<String>) {")
            w.appendLine("    val resourcesDir = args.getOrElse(0) {")
            w.appendLine("        error(\"Argumento resourcesDir não fornecido\")")
            w.appendLine("    }")
            w.appendLine()

            for (item in items) {
                val (jsonPath, varName) = resolveOutputPath(item)
                w.appendLine("    // ${item.annotationType}: ${item.id}")
                w.appendLine("    run {")
                w.appendLine("        val def = ${item.qualifiedName}.definition")
                w.appendLine("        val out = File(\"\$resourcesDir/$jsonPath\")")
                w.appendLine("        out.parentFile.mkdirs()")
                w.appendLine("        out.writeText(json.encodeToString(def))")
                w.appendLine("        println(\"[HytaleRunner] Gerado: \${out.path}\")")
                w.appendLine("    }")
                w.appendLine()
            }

            w.appendLine("    println(\"[HytaleRunner] Completed: ${items.size} arquivo(s) gerado(s)\")")
            w.appendLine("}")
        }

        logger.info("[HytaleKSP] HytaleRunner.kt gerado com ${items.size} definições")
    }

    private fun resolveOutputPath(item: AnnotatedItem): Pair<String, String> {
        val sub = item.outputPath.ifBlank { item.id }
        val jsonPath = when (item.annotationType) {
            "Item"            -> "Server/Item/Items/$sub/${item.id}.json"
            "Model"           -> "Server/Models/$sub/${item.id}.json"
            "RootInteraction" -> "Server/Item/RootInteractions/$sub/${item.id}.json"
            "Interaction"     -> "Server/Item/Interactions/$sub/${item.id}.json"
            else              -> "Server/Unknown/${item.id}.json"
        }
        return jsonPath to item.id
    }
}