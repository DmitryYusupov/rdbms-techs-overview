package ru.yusdm.technics.springdata

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import ru.yusdm.technics.jpa.demo.*


@SpringBootApplication
class SpringDataApplication : CommandLineRunner {

    @Autowired
    lateinit var userService: UserService

    override fun run(vararg args: String) {
        userService.save()
        val users = userService.findAll()
        println()
    }

}

fun main(vararg args: String){
    SpringApplication.run(SpringDataApplication::class.java, *args)
}

