import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import ru.yusdm.technincs.scripts.JooqConfig

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("nu.studer.jooq")

    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    kotlin("plugin.allopen") version "1.3.61"
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

group = "ru.yusdm.lecture"
version "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    implementation("org.jooq:jooq-codegen")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    jooqGenerator("org.postgresql:postgresql:42.2.14")
    jooqGenerator(project(":code-generator-strategy"))

    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.postgresql:postgresql")
}

val postgresqlJooqConfig = JooqConfig(
    driver = "org.postgresql.Driver",
    url = "jdbc:postgresql://localhost:5432/javaquiz",
    user = "test",
    password = "111",
    schema = "public",
    jooqMetaDbName = "org.jooq.meta.postgres.PostgresDatabase",
    packageName = "ru.yusdm.technics.jooq.jooq.autogenerated",
    directory = "src/main/java"
)

val jooqConfig = postgresqlJooqConfig


jooq {
    edition.set(nu.studer.gradle.jooq.JooqEdition.OSS)  // default (can be omitted)

    configurations {
        create("main") {  // name of the jOOQ configuration
            generateSchemaSourceOnCompilation.set(false)  // default (can be omitted)

            jooqConfiguration.apply {
                logging = org.jooq.meta.jaxb.Logging.WARN
                jdbc.apply {
                    driver = jooqConfig.driver
                    url = jooqConfig.url
                    user = jooqConfig.user
                    password = jooqConfig.password
                    //properties.add(org.jooq.meta.jaxb.Property().withKey("ssl").withValue("true"))
                }
                generator.apply {
                    name = "org.jooq.codegen.DefaultGenerator"
                    database.apply {
                        name = "org.jooq.meta.postgres.PostgresDatabase"
                        inputSchema = jooqConfig.schema
                        excludes = jooqConfig.exclude
                        forcedTypes.addAll(
                            arrayOf(
                                org.jooq.meta.jaxb.ForcedType()
                                    .withName("varchar")
                                    .withIncludeExpression(".*")
                                    .withIncludeTypes("JSONB?"),
                                org.jooq.meta.jaxb.ForcedType()
                                    .withName("varchar")
                                    .withIncludeExpression(".*")
                                    .withIncludeTypes("INET")
                            ).toList()
                        )
                    }
                    generate.apply {
                        isDeprecated = false
                        isRecords = true
                        isImmutablePojos = true
                        isFluentSetters = true
                        isRelations = true
                        isPojos = true
                        isDaos = true
                        isValidationAnnotations = true
                    }
                    target.apply {
                        packageName = jooqConfig.packageName
                        directory = jooqConfig.directory
                    }
                    //add J to generated props
                    // strategy.name = "org.jooq.codegen.example.JPrefixGeneratorStrategy"
                    strategy.name = "ru.yusdm.technics.DefaultNamingStrategy"
                }
            }
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}