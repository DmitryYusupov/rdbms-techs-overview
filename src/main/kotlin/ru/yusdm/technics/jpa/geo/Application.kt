package ru.yusdm.technics.jpa.geo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application : CommandLineRunner{

    @Autowired
    lateinit var service: ServiceDefault

    override fun run(vararg args: String) {
     /*   val country3 = Country(0, "Country_1", 1, mutableListOf())
        service.insertCountryWithSpringData(country3)
*/
        val country = Country(null, "Country_1", 1, mutableListOf())
        val country2 = Country(null, "Country_2", 1, mutableListOf())
        service.insertCountry(country)
        service.insertCountry(country2)




        val city = City(null, country, "street", "mainStreet")
        val city2 = City(null, country, "street_2", "mainStreet_2")
        service.insertCity(city)
        service.insertCity(city2)


        //service.getCitiesByCountryId(country.id!!).forEach { println(it.id.toString() + " " + it.name) }
        //service.getCitiesByCountryId2(country.id!!).forEach { println(it.id.toString() + " " + it.name) }
        //service.getCitiesByCountryId3(country.id!!).forEach { println(it.id.toString() + " " + it.name) }
    }

}

fun main(vararg args: String){
    SpringApplication.run(Application::class.java, *args)
}

