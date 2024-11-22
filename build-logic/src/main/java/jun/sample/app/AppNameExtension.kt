package jun.sample.app

import org.gradle.api.Project

fun Project.setNamespace(name: String) {
    androidExtension.apply {
        namespace = "jun.sample.app.$name"
    }
}