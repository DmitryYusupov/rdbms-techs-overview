package ru.yusdm.technics.jpa.demo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service

class PersonService(private val personRepo: PersonRepo) {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun getById(id: Long) : Person {
        return personRepo.getOne(id)
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun getByIdWithLock(id: Long): Person {

        val result =  personRepo.getByIdWithLock(id)
        Thread.sleep(9000)
        return result
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun updateById(id: Long): Person {
        val result =  personRepo.getOne(id)
        result.name = "New name"
        personRepo.save(result)
        return result
    }

    fun save(p: Person) {
        personRepo.save(p)
    }
}