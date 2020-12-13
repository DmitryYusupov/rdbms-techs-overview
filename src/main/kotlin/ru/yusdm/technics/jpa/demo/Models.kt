package ru.yusdm.technics.jpa.demo

import javax.persistence.*

@Entity
@Table
class Person (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    var id: Long? = null,
    var name: String
)

data class PersonDto(val id: Long, val name: String)

fun Person.toDto() : PersonDto {
    return PersonDto(this.id!!, this.name)
}


@Entity
@Table
class Country(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    var id: Long? = null,

    var name: String,

    var population: Int,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    //@OneToMany(fetch = FetchType.LAZY)
    var cities: MutableList<City>
)

@Entity
@Table
class City(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "country_id")
    private var country: Country,

    var name: String,

    var mainStreet: String
)