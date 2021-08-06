plugins {
    kotlin("multiplatform") apply false
}


allprojects {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
        jcenter()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    }
}

/*project(":p2").tasks.configureEach {
    // 🤷‍ It's a demo. Who really cares?
    dependsOn(":p1:publishToMavenLocal")
}*/
