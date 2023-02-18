//
//plugins {
//    id("org.springframework.boot") version "2.7.8"
//    id("io.spring.dependency-management") version "1.0.15.RELEASE"
//    kotlin("jvm") version "1.6.21"
//    kotlin("plugin.spring") version "1.6.21"
//    kotlin("plugin.jpa") version "1.6.21"
//}

group = "world.haebang"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2021.0.5"

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("com.h2database:h2")

    // json serialize configuration
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

    // swagger
    implementation("org.springdoc:springdoc-openapi-ui:1.6.13")
}

project(":talchul-haebang-api") {
    dependencies {
        implementation(project(":talchul-haebang-core"))
    }
}
