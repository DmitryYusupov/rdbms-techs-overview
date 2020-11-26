package ru.yusdm.technics.jpa.geo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RepoSpringData : JpaRepository<Country, Long>
