import jun.sample.app.configureCoroutineAndroid
import jun.sample.app.configureHiltAndroid
import jun.sample.app.configureKotest
import jun.sample.app.configureKotlinAndroid

plugins {
    id("com.android.library")
}

configureKotlinAndroid()
configureKotest()
configureCoroutineAndroid()
configureHiltAndroid()