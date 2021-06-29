pluginManagement {
//    val kotlinVersion = "1.5.255-SNAPSHOT"
    val kotlinVersion = "1.5.30-dev-2892"
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    }
    plugins {
        kotlin("multiplatform") version kotlinVersion
//        kotlin("android") version kotlinVersion
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
