package ru.yusdm.technics.b

import org.springframework.jdbc.core.BatchPreparedStatementSetter
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.transaction.support.TransactionTemplate
import java.sql.PreparedStatement
import javax.sql.DataSource

fun getDatasource(): DataSource {
    throw UnsupportedOperationException("Not now")
}

fun insertCountry(country: Country) {
    val ds = getDatasource()
    val txTemplate = TransactionTemplate(DataSourceTransactionManager(ds))

    txTemplate.execute {
        val jdbcTemplate = JdbcTemplate(ds)
        val holder = GeneratedKeyHolder()

        jdbcTemplate.update({ con ->
            with(con.prepareStatement("INSERT INTO country(NAME, POPULATION) VALUES (?, ?)")) {
                this.setString(1, country.name)
                this.setInt(2, country.population)
                this
            }
        }, holder)

        if (country.cities.isNotEmpty()) {
            val sql = "INSERT INTO city(COUNTRY_ID, NAME, MAIN_STREET) VALUES (?, ?, ?)"
            jdbcTemplate.batchUpdate(sql, object : BatchPreparedStatementSetter {

                override fun setValues(ps: PreparedStatement, i: Int) {
                    ps.setLong(1, holder.key!!.toLong())
                    ps.setString(2, country.cities[i].name)
                    ps.setString(3, country.cities[i].mainStreet)
                }

                override fun getBatchSize(): Int = country.cities.size
            })
        }
    }
}

fun getCitiesByCountryId(countryId: Long): List<City> {
    val sql = "SELECT ct.* FROM country cntr INNER JOIN CITY ct ON (ct.COUNTRY_ID = cntr.ID) WHERE cntr.ID = ?"
    return JdbcTemplate(getDatasource()).query(sql, arrayOf(countryId)) { rs, _ ->
        City(rs.getLong("<FIELD>"), rs.getString("<FIELD>"), rs.getString("<FIELD>"))
    }

}