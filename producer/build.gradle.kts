plugins {
    id("org.springframework.cloud.contract")
    id("io.spring.dependency-management")
    id("maven-publish")
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

val springBootVersion by extra { "2.2.2.RELEASE" }

dependencies {
    testImplementation("junit:junit")
    testImplementation("org.springframework.cloud:spring-cloud-starter-contract-verifier:$springBootVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-jersey:$springBootVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-jetty:$springBootVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion")
    testImplementation("io.rest-assured:json-path")
    testImplementation("org.projectlombok:lombok:1.18.8")
    testImplementation("net.logstash.logback:logstash-logback-encoder:6.3")
    testImplementation("ch.qos.logback:logback-classic")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.9.8")

    annotationProcessor("org.projectlombok:lombok:1.18.8")
}

tasks.test {
    // ignore running contract tests on producer site
    onlyIf {false}
}

// For publishing stubs, https://cloud.spring.io/spring-cloud-contract/2.0.x/multi/multi__spring_cloud_contract_verifier_messaging.html
extra["contractsDir"] = file("mappings")
extra["stubsOutputDirRoot"] = file("${project.buildDir}/production/${project.name}-stubs/")
