plugins {
    id("com.android.application")
}

android {
    namespace = "qing.albatross.injector"
    compileSdk = 34

    defaultConfig {
        applicationId = "qing.albatross.injector"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    val useSourceModules = gradle.extra.has("albatrossSourceAvailable") &&
            gradle.extra["albatrossSourceAvailable"] as? Boolean == true

    if (useSourceModules) {
        compileOnly(project(":annotation"))
        compileOnly(project(":core"))
    } else {
        compileOnly("qing.albatross:annotation-release:1.0@aar")
        compileOnly("qing.albatross:core-release:1.0@aar")
        logger.lifecycle("[$name] Using Albatross libraries as AAR files.")
    }
    compileOnly(project(":app_agent_lib"))
}