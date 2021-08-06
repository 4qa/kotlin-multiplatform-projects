pluginManagement {
    val kotlinVersion = "1.6.0-dev-2524"
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    }
    plugins {
        kotlin("multiplatform") version kotlinVersion
        kotlin("android") version kotlinVersion
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:4.0.2")
            }
        }
    }
}

rootProject.name = "mpp-issue-bootstrap"
include(":p2")
