package ru.yusdm.technics.jpa.demo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PersonService(private val personRepo: PersonRepo) {

    fun getById(id: Long) : Person {
        return personRepo.getOne(id)
    }

    fun getByIdWithLock(id: Long): Person {

        val result =  personRepo.getByIdWithLock(id)
        Thread.sleep(5000)
        return result
    }

    fun save(p: Person) {
        personRepo.save(p)
    }
}