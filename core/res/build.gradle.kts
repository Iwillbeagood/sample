import jun.sample.app.setNamespace

plugins {
    alias(libs.plugins.jun.android.library)
}

android {
    setNamespace("res")
}