package com.example.myapplication

import com.kaspersky.kaspresso.kaspresso.Kaspresso
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class VideoRule() : TestRule {

//    val provider = instrumentalDependencyProviderFactory.getComponentProvider<Kaspresso>(instrumentation)
//    val allureResourcesFilesProvider = resourceFilesProvider as AllureResourceFilesProvider

    private val kaspressoBuilder: Kaspresso.Builder = Kaspresso.Builder.simple()

    override fun apply(base: Statement?, description: Description?): Statement =
        object : Statement() {
            override fun evaluate() {
                kaspressoBuilder.videos.record("Test_Video")
                with(runCatching {
                    base?.evaluate()
                }) {
                    kaspressoBuilder.videos.saveAndApply { attachVideoToAllureReport() }
                    getOrThrow()
                }
            }
        }
}