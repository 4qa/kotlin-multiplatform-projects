plugins {
    kotlin("multiplatform")
}

kotlin {
    val macosA = macosX64("macosA")
    val macosB = macosX64("macosB")
//    val macosB = linuxX64("macosB")  // for some reason way faster


    val commonMain by sourceSets.getting
    val nativeMain by sourceSets.creating{
        dependsOn(commonMain)
    }
    val macosAMain by sourceSets.getting
    val macosBMain by sourceSets.getting


    macosAMain.dependsOn(nativeMain)
//    macosBMain.dependsOn(nativeMain)   // uncomment me


    macosA.compilations.getByName("main").cinterops.create("curl")
    macosA.compilations.getByName("main").cinterops.create("sqlite")


    sourceSets.all {
        languageSettings.optIn("kotlin.RequiresOptIn")
    }
}
