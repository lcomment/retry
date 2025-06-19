dependencies {
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.aspects)

    implementation(libs.resilience4j.spring.boot3)

    implementation(libs.awspring.cloud.dependencies)
    implementation(libs.awspring.cloud.starter.sqs)

    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.kotest.junit)
}

tasks.bootJar {
    archiveBaseName.set("sqs-retry-consumer")
    archiveVersion.set("")
    archiveClassifier.set("")

    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}
