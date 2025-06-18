dependencies {
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.retry)
    implementation(libs.spring.aspects)

    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.kotest.junit)
}

tasks.bootJar {
    archiveBaseName.set("spring-retry-example")
    archiveVersion.set("")
    archiveClassifier.set("")

    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}
