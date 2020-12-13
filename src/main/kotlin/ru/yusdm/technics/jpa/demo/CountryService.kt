package ru.yusdm.technics.jpa.demo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CountryService(private val repo: CountryRepoImplicit, private val countryRepo: CountryRepo) {

    fun getById(id: Long) : Country {
        return countryRepo.getOne(id)
    }

    fun getByIdWithLock(id: Long): Country {

        val result =  countryRepo.getByIdWithLock(id)
        Thread.sleep(5000)
        return result
    }

    fun insertCountryWithSpringData(country: Country) {
        countryRepo.save(country)
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
        val result = repo.getCitiesByCountryId(countryId)
        result.size

        return result
    }

    fun getCitiesByCountryId3(countryId: Long): List<City> {
        return repo.getCitiesByCountryIdWithQuery(countryId)
    }
}