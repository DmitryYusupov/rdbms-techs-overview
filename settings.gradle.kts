rootProject.name = "rdbms-techs-overview"

pluginManagement {
    val nuStuderJooqVersion: String by settings
    val orgSpringframeworkBoot: String by settings
    val ioSpringDependencyManagement: String by settings
    val kotlinJvm: String by settings
    val kotlinPluginSpring: String by settings
    val kotlinPluginJpa: String by settings

    plugins {
        id("nu.studer.jooq") version nuStuderJooqVersion
        id("org.springframework.boot") version orgSpringframeworkBoot
        id("io.spring.dependency-management") version ioSpringDependencyManagement

        kotlin("jvm") version kotlinJvm
        kotlin("plugin.spring") version kotlinPluginSpring
        kotlin("plugin.jpa") version kotlinPluginJpa
    }
}
include("code-generator-strategy")
