package jun.sample.app

import org.gradle.api.Project

internal fun Project.configureKotestAndroid() {
    configureKotest()
    configureJUnitAndroid()
}

@Suppress("UnstableApiUsage")
internal fun Project.configureJUnitAndroid() {
    androidExtension.apply {
        testOptions {
            unitTests.all { it.useJUnitPlatform() }
            unitTests.isReturnDefaultValues = true
        }
    }
}