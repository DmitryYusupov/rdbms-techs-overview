package ru.yusdm.technics.springdata

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(private val userRepository: UserRepository) {

    fun save() {
        userRepository.save(User("Dmitry"))
    }

    fun findAll(): List<User> {
        return userRepository.findAll()
    }

}