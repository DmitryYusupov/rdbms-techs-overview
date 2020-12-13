package ru.yusdm.technics.jpa.demo.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.yusdm.technics.jpa.demo.Person
import ru.yusdm.technics.jpa.demo.PersonDto
import ru.yusdm.technics.jpa.demo.PersonService
import ru.yusdm.technics.jpa.demo.toDto

@RestController
@RequestMapping("/api")
class RestController(private val personService: PersonService) {

    @GetMapping("/locking")
    fun getLocking() : PersonDto {
        return personService.getByIdWithLock(1L).toDto()
    }

    @GetMapping("/none_locking")
    fun getNonLocking() : PersonDto {
        return personService.getById(1L).toDto()
    }
}