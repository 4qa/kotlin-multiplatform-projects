
/**
 * INTEROP BUNDLE PRODUCER (p1)
 */

plugins {
    kotlin("cinterop")
    `maven-publish`
}

cInterop {
    macosX64 {

    }
    linuxX64 {
        
    }
}

dependencies {
    macos_x64(files("libs/macos_x64/curl.klib"))
    linux_x64(files("libs/linux_x64/curl.klib"))
}

tasks.create<Delete>("clean") {
    delete(buildDir)
}
