package ru.yusdm.technics.a

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

fun getConnection(): Connection {
    throw UnsupportedOperationException("Not now")
}

fun insertCountry(country: Country) {

    fun insertCountry(connection: Connection) {
        val sql = "INSERT INTO country(NAME, POPULATION) VALUES (?, ?)"
        connection.createPreparedStatementAndExecuteUpdate(sql, country) { ps, c ->
            ps.setString(1, c.name)
            ps.setInt(2, c.population)
        }
    }

    fun insertCities(connection: Connection) {
        val sql = "INSERT INTO city(COUNTRY_ID, NAME, MAIN_STREET) VALUES (?, ?, ?)"

        country.cities.forEach { city ->
            connection.createPreparedStatementAndExecuteUpdate(sql, city) { ps, c ->
                ps.setLong(1, 1L)
                ps.setString(2, c.name)
                ps.setString(3, c.mainStreet)
            }
        }
    }

    getConnection().use {
        it.autoCommit = false
        insertCountry(it)

        if (country.cities.isNotEmpty()) {
            insertCities(it)
        }
        it.commit()
    }
}

fun getCitiesByCountryId(countryId: Long): List<City> {
    var connection: Connection? = null
    var ps: PreparedStatement? = null
    var rs: ResultSet? = null

    return try {
        connection = getConnection()
        val sql = "SELECT ct.* FROM country cntr INNER JOIN city ct ON (ct.COUNTRY_ID = cntr.ID) WHERE cntr.ID = ?"
        ps = connection.prepareStatement(sql)
        rs = ps.executeQuery()

        val result = mutableListOf<City>()
        while (rs.next()) {
            result.add(
                City(1L, rs.getString("<FIELD>"), rs.getString("<FIELD>"))
            )
        }

        result
    } finally {
        rs?.closeSilently()
        ps?.closeSilently()
        connection?.closeSilently()
    }
}

fun <T> Connection.createPreparedStatementAndExecuteUpdate(
    sql: String,
    domain: T,
    mapper: (ps: PreparedStatement, domain: T) -> Unit
): Int {

    return this.prepareStatement(sql).use {
        mapper(it, domain)
        it.executeUpdate()
    }
}

fun AutoCloseable.closeSilently() {
    try {
        this.close()
    } catch (e: Exception) {
        //e.printStackTrace()
    }
}