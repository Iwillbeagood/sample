import jun.sample.app.setNamespace

plugins {
    alias(libs.plugins.jun.android.library)
}

android {
    setNamespace("testing")
}

dependencies {
    api(libs.junit4)
    api(libs.junit.vintage.engine)
    api(libs.kotlin.test)
    api(libs.mockk)
    api(libs.turbine)
    api(libs.coroutines.test)
    api(libs.androidx.compose.ui.test)
    api(libs.mockwebserver)
    implementation(libs.hilt.android.testing)
    implementation(libs.androidx.compose.ui.test)
    implementation(libs.androidx.runner)
}