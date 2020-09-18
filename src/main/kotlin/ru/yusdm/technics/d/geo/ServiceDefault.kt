package ru.yusdm.technics.d.geo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ServiceDefault(
    private val repo: RepoDefault,
    private val repoSpringData: RepoSpringData
) {

    fun insertCountryWithSpringData(country: Country) {
        repoSpringData.save(country)
    }

    fun insertCountry(country: Country) {
        repo.insertCountry(country)
    }

    fun insertCity(city: City) {
        repo.insertCity(city)
    }

    fun getCitiesByCountryId(countryId: Long): List<City> {
        return repo.getCitiesByCountryId(countryId)
    }
































    fun getCitiesByCountryId2(countryId: Long): List<City> {
        val result =  repo.getCitiesByCountryId(countryId)
        result.size

        return result
    }























    fun getCitiesByCountryId3(countryId: Long): List<City> {
        return repo.getCitiesByCountryIdWithQuery(countryId)
    }


}