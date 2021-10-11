import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        jcenter()
        mavenCentral()
        mavenLocal()
    }
    dependencies {
        classpath(Libs.kotlin_stdlib)
        classpath(Libs.kotlin_jdk8)
        classpath(Libs.kotlin_reflect)
    }
}

repositories {
    jcenter()
    mavenCentral()
    mavenLocal()
}

plugins {
    java
    kotlin("jvm")
    id("org.springframework.boot") version Vers.springBoot
    id("io.spring.dependency-management") version Vers.springDependencyVersion
    kotlin("plugin.spring") version Global.kotlin
    jacoco
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                minimum = "0.4".toBigDecimal()
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
    finalizedBy(tasks.jacocoTestCoverageVerification)
}

dependencies {
    // kotlin
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude("org.junit.vintage", "junit-vintage-engine")
    }
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
