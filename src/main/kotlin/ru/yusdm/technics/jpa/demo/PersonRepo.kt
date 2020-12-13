package ru.yusdm.technics.jpa.demo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.persistence.LockModeType

@Repository
interface PersonRepo : JpaRepository<Person, Long> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("SELECT p FROM Person p where p.id = :id")
    fun getByIdWithLock(id: Long): Person
}
