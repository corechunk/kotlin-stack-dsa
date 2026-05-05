plugins {
    kotlin("jvm") version "2.3.21"
    application
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("MainKt")
}
tasks.getByName<JavaExec>("run") {
    standardInput = System.`in`
}
tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
    // This part ensures the Kotlin library is included in the jar (Fat Jar)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}