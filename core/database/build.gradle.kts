import jun.sample.app.setNamespace

plugins {
    alias(libs.plugins.jun.android.library)
    alias(libs.plugins.jun.android.hilt)
    alias(libs.plugins.jun.android.room)
}

android {
    setNamespace("database")
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.utils)
    implementation(libs.junit4)
    implementation(libs.androidx.test.ext)
    implementation(libs.hilt.android.testing)
    implementation(libs.coroutines.test)
    implementation(kotlin("reflect"))
}