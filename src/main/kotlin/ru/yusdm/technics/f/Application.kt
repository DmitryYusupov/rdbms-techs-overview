package ru.yusdm.technics.f

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application : CommandLineRunner {
    override fun run(vararg args: String?) {

    }
}

fun main(vararg args: String){
    SpringApplication.run(Application::class.java, *args)
}