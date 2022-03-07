import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("org.springframework.boot") version "2.5.8-SNAPSHOT"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.3.61"
    kotlin("jvm") version "1.5.0"
    kotlin("plugin.spring") version "1.5.0"
    kotlin("plugin.jpa") version "1.5.0"
    //QueryDSL 추가
    id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"
    id("java")
    kotlin("kapt") version "1.5.0"

}

group = "com.lunastratos"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
    maven { url = uri("https://jitpack.io")}
}

dependencies {
    implementation("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-batch")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.batch:spring-batch-test")


    //WebClient
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    //json
    implementation("com.googlecode.json-simple:json-simple:1.1.1")
    implementation("org.json:json:20210307")

    // QueryDSL1
    implementation("com.querydsl:querydsl-jpa")
    kapt("com.querydsl:querydsl-apt::jpa")

    // QueryDSL2
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor(group = "com.querydsl", name = "querydsl-apt", classifier = "jpa")

    // QueryDSL3
    implementation("com.querydsl:querydsl-sql:4.4.0")

    // QueryDSL - mongoDB
//    implementation("com.querydsl:querydsl-mongodb:4.4.0")


    // Spring Sequrity
    implementation ("org.springframework.boot:spring-boot-starter-security")

    // JWT
    implementation ("io.jsonwebtoken:jjwt:0.9.1")

    // Redis
    implementation ("org.springframework.boot:spring-boot-starter-data-redis")

//    // MongoDB
//    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    // email
    implementation ("org.springframework.boot:spring-boot-starter-mail")

    // 한글 형태소 분석기 KOMORAN 의존성 추가
    //implementation("com.github.shin285:KOMORAN:3.3.4")

    // File extension
    implementation("commons-io:commons-io:2.11.0")

    // Swagger
    implementation ("io.springfox:springfox-swagger2:2.9.2")
    implementation ("io.springfox:springfox-swagger-ui:2.9.2")

    // xss 방어
    implementation("org.apache.commons:commons-text:1.9")




}

//QueryDSL4 경로 추가
sourceSets["main"].withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class){
    kotlin.srcDir("$buildDir/generated/source/kapt/main")
}

allOpen { // 추가적으로 열어줄 allOpen
//    annotation("org.springframework.data.mongodb.core.mapping.Document")
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}




