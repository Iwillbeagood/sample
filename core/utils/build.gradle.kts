import jun.sample.app.setNamespace

plugins {
    alias(libs.plugins.jun.android.library)
}

android {
    setNamespace("utils")

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.core.res)
}