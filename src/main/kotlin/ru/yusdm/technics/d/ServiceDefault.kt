package ru.yusdm.technics.d

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ServiceDefault(
    private val repo: RepoDefault
) {

}