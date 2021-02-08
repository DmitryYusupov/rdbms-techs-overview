package ru.yusdm.technics.jpa.demo.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.yusdm.technics.jpa.demo.PersonDto
import ru.yusdm.technics.jpa.demo.PersonService
import ru.yusdm.technics.jpa.demo.toDto

@RestController
@RequestMapping("/api")
class RestController(private val personService: PersonService) {

    @GetMapping("/write_locking")
    fun getLocking(): PersonDto {
        return personService.getByIdWithWriteLock(1L).toDto()
    }

    @GetMapping("/none_locking")
    fun getNonLocking(): PersonDto {
        return personService.getById(1L).toDto()
    }

    @GetMapping("/read_locking")
    fun getLocking2(): PersonDto {
        return personService.getByIdWithReadLock(1L).toDto()
    }

    @GetMapping("/update")
    fun getUpdate(): PersonDto {
        return personService.updateById(1L).toDto()
    }

    @GetMapping("/lock_all_with_read_lock")
    fun lockAllWithReadLock(): List<PersonDto> {
        return personService.lockAllWithReadLock().map { it.toDto() }
    }

    @GetMapping("/lock_all_with_write_lock")
    fun lockAllWithWriteLock(): List<PersonDto> {
        return personService.lockAllWithWriteLock().map { it.toDto() }
    }

    @GetMapping("/delete")
    fun deletePerson() {
        personService.deleteById(1L)
    }

    @GetMapping("/insert")
    fun insertPerson() {
        personService.insertPerson()
    }
}

/*

[APP _1 [update, send JMS..................................|...]]

                           [JMS]->[1L -> getById]--------------> []
                           [JMS]->[1L -> getById]--> []

 */