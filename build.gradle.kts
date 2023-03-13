plugins {
    kotlin("jvm") version "1.8.0"
    id("org.openapi.generator") version "6.4.0"
}

group = "dev.themeinerlp"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
openApiGenerate {
    generatorName.set("java")
    remoteInputSpec.set("https://hangar.papermc.io/v3/api-docs.yaml")
    apiPackage.set("dev.themeinerlp.hangar.api")
    invokerPackage.set("dev.themeinerlp.hangar.invoker")
    modelPackage.set("dev.themeinerlp.hangar.model")
}