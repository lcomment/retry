dependencies {
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.aspects)

    implementation(libs.resilience4j.spring.boot3)

    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.kotest.junit)
}

tasks.bootJar {
    archiveBaseName.set("resilience4j-retry-example")
    archiveVersion.set("")
    archiveClassifier.set("")

    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}
