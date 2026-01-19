plugins {
    kotlin("jvm") version "2.3.0"
    id("com.gradleup.shadow") version "9.3.1"
    // Reference to graddle/libs.versions -> plugins -> kotlinPluginSerialization
    alias(libs.plugins.kotlinPluginSerialization)
}

group = "gg.forgeone"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // compileOnly => only for compilation, not in the final jar
    compileOnly(files("libs/HytaleServer.jar"))

    // Reference to graddle/libs.versions -> bundles -> kotlinx(-)(.)ecosystem
    implementation(libs.bundles.kotlinx.ecosystem)

    //    only for import lib (not the bundle)
    //    implementation(libs.kotlinxSerializationJson)
}

tasks.test {
    useJUnitPlatform()
}

tasks.shadowJar {
    // Name of the jar
    archiveBaseName.set(rootProject.name)
    archiveClassifier.set("")
    // Change namespace of imported libraries to prevent conflict with other jar using same libraries
    //    relocate("org.jetbrains.kotlinx", "fr.ftnl.libs.kotlinx")
    // Minifing classes
    minimize()
}