package ru.yusdm.technics.jpa.demo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.persistence.LockModeType
//https://stackoverflow.com/questions/1657124/whats-the-difference-between-pessimistic-read-and-pessimistic-write-in-jpa
@Repository
interface PersonRepo : JpaRepository<Person, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT p FROM Person p where p.id = :id")
    fun getByIdWithWriteLock(id: Long): Person

    //@Lock(LockModeType.PESSIMISTIC_READ)
    //@Query("SELECT p FROM Person p where p.id = :id")
    @Query(nativeQuery = true, value = "SELECT * FROM Person where id = :id for update")
    fun getByIdWithReadLock(id: Long): Person

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT p FROM Person p")
    fun getAllWithLockWrite() : List<Person>

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("SELECT p FROM Person p")
    fun getAllWithLockRead() : List<Person>
}
