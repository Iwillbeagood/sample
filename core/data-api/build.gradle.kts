import jun.sample.app.setNamespace

plugins {
    alias(libs.plugins.jun.android.library)
}

android {
    setNamespace("data_api")
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.navigation)
    implementation(projects.core.datastore)
}