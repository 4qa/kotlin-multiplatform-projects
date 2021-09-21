/**
 * INTEROP BUNDLE CONSUMER (p2)
 */

plugins {
    kotlin("multiplatform")
}

kotlin {
    val macos = macosX64("macos")
//    val linux = linuxX64("linux")

    val commonMain by sourceSets.getting
    val commonTest by sourceSets.getting

    val nativeMain by sourceSets.creating
    val nativeTest by sourceSets.creating
    val macosMain by sourceSets.getting
    val macosTest by sourceSets.getting

//    val linuxMain by sourceSets.getting
//    val linuxTest by sourceSets.getting

    nativeMain.dependsOn(commonMain)
    nativeTest.dependsOn(commonTest)

    macosMain.dependsOn(nativeMain)
    macosTest.dependsOn(nativeTest)
//
//    linuxMain.dependsOn(nativeMain)
//    linuxTest.dependsOn(nativeTest)

    sourceSets.all {
        languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
    }

    macos.compilations.getByName("main").cinterops.create("curl")
    macos.compilations.getByName("test").cinterops.create("curl")

    macos.compilations.getByName("main").cinterops.create("sqlite")
    macos.compilations.getByName("test").cinterops.create("sqlite")

//    linux.compilations.getByName("main").cinterops.create("curl")
//    linux.compilations.getByName("main").cinterops.create("sqlite")
}
