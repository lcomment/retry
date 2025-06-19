rootProject.name = "retry-best-practices"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.6.0"
}

module(name = ":spring-retry", "spring-retry")
module(name = ":resilience4j-retry", "resilience4j-retry")
module(name = ":sqs-retry", "sqs-retry")
module(name = ":sqs-producer", "sqs-retry/producer")
module(name = ":sqs-consumer", "sqs-retry/consumer")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("libs.versions.toml"))
        }
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

fun module(name: String, path: String) {
    include(name)
    project(name).projectDir = file(path)
}

