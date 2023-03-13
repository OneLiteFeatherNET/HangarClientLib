plugins {
    kotlin("jvm") version "1.8.0"
    id("org.openapi.generator") version "6.4.0"
    `maven-publish`
}

group = "dev.themeinerlp"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks {
    publish {
        dependsOn("openApiGenerate")
    }
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
publishing {
    repositories {
        maven {
            name = "GithubPackages"
            url = uri("https://maven.pkg.github.com/OneLiteFeatherNET/HangarClientLib")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password  = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}