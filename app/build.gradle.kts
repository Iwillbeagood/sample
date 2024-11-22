plugins {
    alias(libs.plugins.jun.android.application)
}

android {
    namespace = "jun.sample.app"

    defaultConfig {
        applicationId = "jun.sample.app"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.utils)
    implementation(projects.core.model)
    implementation(projects.core.res)

    implementation(projects.feature.main)

    implementation(libs.firebase.core)
    implementation(libs.firebase.messaging)
    implementation(libs.gson)
}