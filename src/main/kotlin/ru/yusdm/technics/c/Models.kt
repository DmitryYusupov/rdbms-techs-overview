package ru.yusdm.technics.c

data class Country(
    val name: String,
    val population: Int,
    val cities: MutableList<City>
)

data class City(val name: String, val mainStreet: String)