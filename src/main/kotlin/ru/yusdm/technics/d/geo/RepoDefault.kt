package ru.yusdm.technics.d.geo

import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class RepoDefault(private val em: EntityManager) {

    fun insertCountry(country: Country) {
        em.persist(country)
    }

    fun insertCity(city: City) {
        em.persist(city)
    }

    fun getCitiesByCountryId(countryId: Long): List<City> {
        return em.find(Country::class.java, countryId).cities
    }

}