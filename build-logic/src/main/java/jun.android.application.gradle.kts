import jun.sample.app.configureHiltAndroid
import jun.sample.app.configureKotestAndroid
import jun.sample.app.configureKotlinAndroid


plugins {
    id("com.android.application")
}

configureKotlinAndroid()
configureHiltAndroid()
configureKotestAndroid()
