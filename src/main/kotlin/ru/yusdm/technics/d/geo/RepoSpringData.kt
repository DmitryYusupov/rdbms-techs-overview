package ru.yusdm.technics.d.geo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RepoSpringData : JpaRepository<Country, Long>
