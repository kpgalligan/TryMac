plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    `maven-publish`
}

kotlin {
    androidTarget {
        publishAllLibraryVariants()
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    macosX64()
    macosArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.touchlab.stately.concurrency)
        }
    }
}

// For publishing Android AAR files to GitHub Packages
addGithubPackagesRepository()

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
    namespace = "co.touchlab.kmmbridgekickstart.analytics"
}