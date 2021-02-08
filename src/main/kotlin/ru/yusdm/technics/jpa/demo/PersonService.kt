package ru.yusdm.technics.jpa.demo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Service
class PersonService(private val personRepo: PersonRepo, val em: EntityManager) {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun getById(id: Long): Person {
        return personRepo.getOne(id)
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun getByIdWithWriteLock(id: Long): Person {
        println("Write lock acquired-------------")
        val result = personRepo.getByIdWithWriteLock(id)
        result.name = "UPDATED_IN_WRITE_LOCK"
        personRepo.save(result)
        em.flush()
        Thread.sleep(45000)
        //
        println("Write lock released--------------")
        return result
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun getByIdWithReadLock(id: Long): Person {
        println("Read lock acquired-------------")
        val result = personRepo.getByIdWithReadLock(id)
        Thread.sleep(15000)
        println("Read lock acquired--------------")
        return result
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun updateById(id: Long): Person {
        println("---update begin---------")
        val result = personRepo.getOne(id)
        result.name = "UPDATED NAME"
        personRepo.save(result)
        println("---update end---------")
        return result
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun deleteById(id: Long) {
        personRepo.deleteById(id)
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun lockAllWithReadLock(): List<Person> {
        val result = personRepo.getAllWithLockRead()
        Thread.sleep(25000)
        return result
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun lockAllWithWriteLock(): List<Person> {
        val result = personRepo.getAllWithLockWrite()
        Thread.sleep(15000)
        return result
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun insertPerson() {
        val total = personRepo.count()
        personRepo.save(Person(total + 1, "NAME_" + (total + 1)))
    }


    fun save(p: Person) {
        personRepo.save(p)
    }
}