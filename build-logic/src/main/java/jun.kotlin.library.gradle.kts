import jun.sample.app.configureHiltKotlin
import jun.sample.app.configureKotest
import jun.sample.app.configureKotlin

plugins {
    kotlin("jvm")
}

configureKotlin()
configureKotest()
configureHiltKotlin()