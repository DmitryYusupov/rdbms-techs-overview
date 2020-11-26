package ru.yusdm.technics.namedparameterjdbctemplate

data class Country(
    val id: Long,
    val name: String,
    val population: Int,
    val cities: MutableList<City>
)

data class City(val id: Long, val name: String, val mainStreet: String)