package ru.yusdm.technics.namedparameterjdbctemplate

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.transaction.support.TransactionTemplate
import ru.yusdm.technics.jdbctemplate.City
import ru.yusdm.technics.jdbctemplate.Country
import javax.sql.DataSource

fun getDatasource(): DataSource {
    throw UnsupportedOperationException("Not now")
}

fun insertCountry(country: Country) {
    val ds = getDatasource()
    val txTemplate = TransactionTemplate(DataSourceTransactionManager(ds))

    txTemplate.execute {
        val jdbcTemplate = NamedParameterJdbcTemplate(JdbcTemplate(ds))
        val holder = GeneratedKeyHolder()

        jdbcTemplate.update(
            "INSERT INTO country(NAME, POPULATION) VALUES (:name, :population)",
            MapSqlParameterSource(mapOf("name" to country.name, "population" to country.population)),
            holder
        )

        if (country.cities.isNotEmpty()) {
            val sql = "INSERT INTO city(COUNTRY_ID, NAME, MAIN_STREET) VALUES (:countryId, :name, :street)"
            jdbcTemplate.batchUpdate(sql, country.cities.asSequence()
                .map {
                    mapOf(
                        "countryId" to country.id,
                        "name" to it.name,
                        "street" to it.mainStreet
                    )
                }
                .toList().toTypedArray()
            )
        }
    }
}

fun getCitiesByCountryId(countryId: Long): List<City> {
    val sql = "SELECT ct.* FROM country cntr INNER JOIN CITY ct ON (ct.COUNTRY_ID = cntr.ID) WHERE cntr.ID = ?"
    return JdbcTemplate(getDatasource()).query(sql, arrayOf(countryId)) { rs, _ ->
        City(rs.getLong("<FIELD>"), rs.getString("<FIELD>"), rs.getString("<FIELD>"))
    }

}