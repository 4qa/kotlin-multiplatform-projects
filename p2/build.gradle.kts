/**
 * INTEROP BUNDLE CONSUMER (p2)
 */

plugins {
    kotlin("multiplatform")
}

kotlin {
    val macos = macosX64("macos")
    val linux = linuxX64("linux")
    val ios = iosX64("ios")

    val commonMain by sourceSets.getting
    val commonTest by sourceSets.getting
    val nativeMain by sourceSets.creating
    val nativeTest by sourceSets.creating
    val macosMain by sourceSets.getting
    val macosTest by sourceSets.getting
    val linuxMain by sourceSets.getting
    val linuxTest by sourceSets.getting
//    val iosMain by sourceSets.getting
    val iosTest by sourceSets.getting

    nativeMain.dependsOn(commonMain)
    macosMain.dependsOn(nativeMain)
    linuxMain.dependsOn(nativeMain)
//    iosMain.dependsOn(nativeMain)

    nativeTest.dependsOn(commonTest)
    macosTest.dependsOn(nativeTest)
    linuxTest.dependsOn(nativeTest)
    iosTest.dependsOn(nativeTest)

    sourceSets.all {
        languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
    }

    macos.compilations.getByName("main").cinterops.create("curl")
    macos.compilations.getByName("test").cinterops.create("curl")
    linux.compilations.getByName("main").cinterops.create("curl")
    linux.compilations.getByName("test").cinterops.create("curl")
    ios.compilations.getByName("main").cinterops.create("curl")
    ios.compilations.getByName("test").cinterops.create("curl")
}
