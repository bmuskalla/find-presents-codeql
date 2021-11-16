plugins {
    java
    id("org.gretty") version "3.0.6"
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(16))
    }
}

gretty {
    contextPath = "/"
    servletContainer = "jetty9"
}

dependencies {
    implementation("javax:javaee-api:7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}