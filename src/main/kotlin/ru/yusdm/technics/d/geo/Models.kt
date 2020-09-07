package ru.yusdm.technics.d.geo

import javax.persistence.*

@Entity
@Table
data class Country(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    val id: Long? = null,

    val name: String,

    val population: Int,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    //@OneToMany(fetch = FetchType.LAZY)
    val cities: MutableList<City>
)

@Entity
@Table
data class City(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "country_id")
    private val country: Country,

    val name: String,

    val mainStreet: String
)