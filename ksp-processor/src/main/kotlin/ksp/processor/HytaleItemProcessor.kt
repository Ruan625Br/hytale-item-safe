package ksp.processor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import dev.ruan625br.hytale.item.safe.annotations.HytaleInteraction
import dev.ruan625br.hytale.item.safe.annotations.HytaleItem
import dev.ruan625br.hytale.item.safe.annotations.HytaleModel
import dev.ruan625br.hytale.item.safe.annotations.HytaleRootInteraction
import ksp.runner.HytaleRunner
import java.io.BufferedWriter
import java.io.File

class HytaleItemProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger,
    private val options: Map<String, String>
): SymbolProcessor {

    private val ANNOTATION_ITEM = HytaleItem::class.qualifiedName!!
    private val ANNOTATION_MODEL = HytaleModel::class.qualifiedName!!
    private val ANNOTATION_ROOT = HytaleRootInteraction::class.qualifiedName!!
    private val ANNOTATION_INTER = HytaleInteraction::class.qualifiedName!!


    private var assetsGenerated = false

    val runner = HytaleRunner(codeGenerator, logger)

    override fun process(resolver: Resolver): List<KSAnnotated> {
        val items = mutableListOf<AnnotatedItem>()

        fun collect(annotationFqn: String, type: String) {
            resolver.getSymbolsWithAnnotation(annotationFqn)
                .filterIsInstance<KSClassDeclaration>()
                .forEach { cls ->
                    val ann = cls.annotations.first {
                        it.annotationType.resolve().declaration.qualifiedName?.asString() as String == annotationFqn
                    }
                    val id = ann.arguments.first { it.name?.asString() == "id" }.value as String
                    val outputPath = (ann.arguments.firstOrNull {
                        it.name?.asString() == "outputPath"
                    }?.value as? String).orEmpty()

                    items += AnnotatedItem(
                        qualifiedName = cls.qualifiedName!!.asString(),
                        id = id,
                        outputPath = outputPath,
                        annotationType = type
                    )
                }
        }

        collect(ANNOTATION_ITEM, "Item")
        collect(ANNOTATION_MODEL, "Model")
        collect(ANNOTATION_ROOT, "RootInteraction")
        collect(ANNOTATION_INTER, "Interaction")

        if (items.isNotEmpty()) {
            runner.generateRunner(items)
        }

        if (!assetsGenerated) {
            generateAssetsObject()
            assetsGenerated = true
        }

        return emptyList()

    }


    private fun generateAssetsObject() {
        val resourcesDirPath = options["hytale.common.dir"]
            ?: run { logger.warn("[HytaleKSP] Opção 'hytale.common.dir' não configurada — Assets.kt não gerado"); return }

        val resourcesDir = File(resourcesDirPath)
        if (!resourcesDir.exists()) {
            logger.warn("[HytaleKSP] Diretório não encontrado: $resourcesDirPath")
            return
        }

        val file = codeGenerator.createNewFile(
            dependencies = Dependencies(aggregating = true),
            packageName = "dev.ruan625br.hytale.item.safe.generated",
            fileName = "Assets"
        )

        file.bufferedWriter().use { w ->
            w.appendLine("// AUTO-GENERATED — do not edit manually")
            w.appendLine("package dev.ruan625br.hytale.item.safe.generated")
            w.appendLine()
            w.appendLine("object Assets {")
            buildAssetsNode(resourcesDir, resourcesDir, w, indent = 1)
            w.appendLine("}")
        }
    }


    private fun buildAssetsNode(
        dir: File,
        root: File,
        writer: BufferedWriter,
        indent: Int
    ) {
        val pad = "    ".repeat(indent)
        val dirs = dir.listFiles()?.filter { it.isDirectory }?.sortedBy { it.name } ?: emptyList()
        val files = dir.listFiles()?.filter { it.isFile }?.sortedBy { it.name } ?: emptyList()

        for (sub in dirs) {
            val objName = sanitizeIdentifier(sub.name)
            writer.appendLine("$pad object $objName {")
            buildAssetsNode(sub, root, writer, indent + 1)
            writer.appendLine("$pad}")
        }

        for (file in files) {
            val relPath = file.relativeTo(root).path.replace("\\", "/")
            val constName = sanitizeIdentifier(file.nameWithoutExtension)
            writer.appendLine("$pad/** `$relPath` */")
            writer.appendLine("$pad const val $constName = \"$relPath\"")
        }
    }

    private fun sanitizeIdentifier(name: String): String =
        name.replace("-", "_").replace(" ", "_")
            .let {
                if (it.first().isDigit()) "_$it" else it

            }
}