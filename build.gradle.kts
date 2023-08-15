plugins {
	java
	id("org.springframework.boot") version "3.1.2"
	id("io.spring.dependency-management") version "1.1.2"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	//jackson json convert
//	implementation ("com.fasterxml.jackson.core:jackson-core:2.9.9")
//	implementation ("com.fasterxml.jackson.core:jackson-annotations:2.9.9")
//	implementation ("com.fasterxml.jackson.core:jackson-databind:2.9.9")
//	implementation ("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.9")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.mysql:mysql-connector-j")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	//롬복추가
	implementation("org.projectlombok:lombok:1.18.22")
	annotationProcessor("org.projectlombok:lombok:1.18.22")

	//RestController때문에추가
	implementation("org.springframework.boot:spring-boot-starter-web")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
