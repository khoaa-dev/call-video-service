import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.2"
	id("io.spring.dependency-management") version "1.0.12.RELEASE"
	id("com.palantir.docker") version "0.34.0"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"

}

group = "com.intern"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	runtimeOnly("mysql:mysql-connector-java")
	runtimeOnly("org.postgresql:postgresql")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("commons-codec:commons-codec:1.15")
	implementation("org.postgresql:postgresql:42.5.0")


	implementation("io.agora.rtc:full-sdk:3.7.0.2")
	implementation("io.agora:authentication:1.6.1")

	implementation("org.springdoc:springdoc-openapi-data-rest:1.6.11")
	implementation("org.springdoc:springdoc-openapi-ui:1.6.11")
	implementation("org.springdoc:springdoc-openapi-kotlin:1.6.11")


	testImplementation("io.mockk:mockk:1.12.7")
	testImplementation("org.apache.httpcomponents:httpclient")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
	testImplementation(platform("org.junit:junit-bom:5.9.0"))
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")

	testImplementation("com.ninja-squad:springmockk:3.1.1")

	testImplementation("org.testcontainers:testcontainers:1.17.3")
	testImplementation("org.testcontainers:mysql:1.17.3")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}


