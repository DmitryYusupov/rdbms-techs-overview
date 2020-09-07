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




















    fun getCitiesByCountryIdWithQuery(countryId: Long): List<City> {
        val query = em.createQuery("SELECT c from City c WHERE c.country.id = :countryId", City::class.java)
        query.setParameter("countryId", countryId)

        return query.resultList
    }

}