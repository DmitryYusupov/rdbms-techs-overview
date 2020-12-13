package ru.yusdm.technics.jpa.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application : CommandLineRunner{

    @Autowired
    lateinit var countryService: CountryService

    @Autowired
    lateinit var personService: PersonService

    override fun run(vararg args: String) {
     /*   val country3 = Country(0, "Country_1", 1, mutableListOf())
        service.insertCountryWithSpringData(country3)
*/
        val country = Country(null, "Country_1", 1, mutableListOf())
        val country2 = Country(null, "Country_2", 1, mutableListOf())
        countryService.insertCountry(country)
        countryService.insertCountry(country2)




        val city = City(null, country, "street", "mainStreet")
        val city2 = City(null, country, "street_2", "mainStreet_2")
        countryService.insertCity(city)
        countryService.insertCity(city2)

        personService.save(Person(null, "TestPerson"))

        //service.getCitiesByCountryId(country.id!!).forEach { println(it.id.toString() + " " + it.name) }
        //service.getCitiesByCountryId2(country.id!!).forEach { println(it.id.toString() + " " + it.name) }
        //service.getCitiesByCountryId3(country.id!!).forEach { println(it.id.toString() + " " + it.name) }
    }

}

fun main(vararg args: String){
    SpringApplication.run(Application::class.java, *args)
}

