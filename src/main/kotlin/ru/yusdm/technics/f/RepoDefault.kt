package ru.yusdm.technics.f

import org.jooq.impl.DefaultConfiguration
import org.jooq.impl.DefaultDSLContext
import org.springframework.stereotype.Repository
import ru.yusdm.technics.f.jooq.autogenerated.Tables.CITY
import ru.yusdm.technics.f.jooq.autogenerated.Tables.COUNTRY
import ru.yusdm.technics.f.jooq.autogenerated.tables.daos.JCityDao
import ru.yusdm.technics.f.jooq.autogenerated.tables.daos.JCountryDao
import ru.yusdm.technics.f.jooq.autogenerated.tables.pojos.JpjCity
import ru.yusdm.technics.f.jooq.autogenerated.tables.pojos.JpjCountry

@Repository
class RepoDefault(
    jooqConfig: DefaultConfiguration,
    private val dsl: DefaultDSLContext
) {
    private val countryRepo = JCountryDao(jooqConfig)
    private val cityRepo = JCityDao(jooqConfig)

    fun insertCountry(country: JpjCountry) {
        countryRepo.insert(country)
    }

    fun insertCountry2(country: MyCountry) : Long {
        return dsl.insertInto(COUNTRY, COUNTRY.NAME, COUNTRY.POPULATION)
            .values(
                with(country) {
                    listOf(this.name, this.population)
                }
            )
            .returningResult(COUNTRY.ID)
            .fetchOne().value1()
    }

    fun insertCity(city: JpjCity) {
        cityRepo.insert(city)
    }

    fun getCitiesByCountryId(countryId: Long): List<JpjCity> {
        return dsl.select()
            .from(CITY)
            .innerJoin(COUNTRY).on(COUNTRY.ID.eq(CITY.COUNTRY_ID))
            .where(COUNTRY.ID.eq(countryId))
            .fetchInto(JpjCity::class.java)
    }

    fun getCitiesByCountryId2(countryId: Long): List<JpjCity> {
        return dsl.select(CITY.fields().toList())
            .from(CITY)
            .innerJoin(COUNTRY).on(COUNTRY.ID.eq(CITY.COUNTRY_ID))
            .where(COUNTRY.ID.eq(countryId))
            .fetchInto(JpjCity::class.java)
    }

}