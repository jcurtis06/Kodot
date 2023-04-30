plugins {
    kotlin("jvm") version "1.8.20"
}

group = "io.jcurtis"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven ("https://jitpack.io")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.github.jcurtis06:Kodot:Tag")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}