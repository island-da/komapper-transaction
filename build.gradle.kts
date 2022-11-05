import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.4"
	id("io.spring.dependency-management") version "1.0.14.RELEASE"
	id("com.google.devtools.ksp") version "1.7.10-1.0.6"
	kotlin("jvm") version "1.7.10"
	kotlin("plugin.spring") version "1.7.10"
}

group = "com.test"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

val komapperVersion: String = "1.4.0"
dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")

	platform("org.komapper:komapper-platform:$komapperVersion").let {
		implementation(it)
		ksp(it)
	}
	implementation("org.komapper:komapper-spring-boot-starter-r2dbc:$komapperVersion")
	runtimeOnly("org.komapper:komapper-dialect-h2-r2dbc")
	ksp("org.komapper:komapper-processor")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
}

kotlin {
	sourceSets.main {
		kotlin.srcDir("build/generated/ksp/main/kotlin")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

springBoot {
	mainClass.set("com.test.KomapperTransactionApplicationKt")
}