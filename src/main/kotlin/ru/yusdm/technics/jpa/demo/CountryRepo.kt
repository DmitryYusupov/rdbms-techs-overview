package ru.yusdm.technics.jpa.demo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.persistence.LockModeType

@Repository
interface CountryRepo : JpaRepository<Country, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT c FROM Country c where c.id = :id")
    fun getByIdWithLock(id: Long): Country


    @Query("SELECT country FROM Country country JOIN City city on country.id = city.country.id")
    fun findCountryWithCitiesById(id: Long): List<Country>

}
