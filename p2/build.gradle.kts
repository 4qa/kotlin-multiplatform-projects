plugins {
    kotlin("multiplatform")
}

kotlin {
    val macosA = macosX64("macosA")
    val macosB = macosX64("macosB")

    val linux = linuxX64("linux")

    val commonMain by sourceSets.getting
    val commonTest by sourceSets.getting

    val nativeMain by sourceSets.creating{
        dependsOn(commonMain)
    }
    val nativeTest by sourceSets.creating{
        dependsOn(commonTest)
    }

    val macosAMain by sourceSets.getting
    val macosBMain by sourceSets.getting

    val macosATest by sourceSets.getting
    val macosBTest by sourceSets.getting

    val linuxMain by sourceSets.getting
    val linuxTest by sourceSets.getting


    macosAMain.dependsOn(nativeMain)
    macosBMain.dependsOn(nativeMain)

    macosATest.dependsOn(nativeTest)
    macosBTest.dependsOn(nativeTest)


    linuxMain.dependsOn(nativeMain)
    linuxTest.dependsOn(nativeTest)

    macosA.compilations.getByName("main").cinterops.create("curl")
    macosB.compilations.getByName("main").cinterops.create("curl")

    macosA.compilations.getByName("main").cinterops.create("sqlite")
    macosB.compilations.getByName("main").cinterops.create("sqlite")

    linux.compilations.getByName("main").cinterops.create("curl")
    linux.compilations.getByName("main").cinterops.create("sqlite")




    sourceSets.all {
        languageSettings.optIn("kotlin.RequiresOptIn")
    }
}
