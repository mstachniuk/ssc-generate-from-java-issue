

plugins {
    id("java")
    id("org.springframework.cloud.contract") version "2.2.2.RELEASE" apply false
    id("org.springframework.boot") version "2.2.2.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
}


allprojects {
    group = "com.example"
    version = "1.0.0"
}
