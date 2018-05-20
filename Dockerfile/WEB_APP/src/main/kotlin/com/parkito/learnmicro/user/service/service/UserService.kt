package com.parkito.learnmicro.user.service.service;

import com.parkito.learnmicro.user.service.dto.UserDTO
import com.parkito.learnmicro.user.service.entity.User
import com.parkito.learnmicro.user.service.exception.value.BusinessLogicException
import com.parkito.learnmicro.user.service.exception.value.ResourceNotFoundException
import com.parkito.learnmicro.user.service.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

/**
 * @author Artem Karnov @date 11/6/2017.
 * artem.karnov@t-systems.com
 */
@Service
class UserService {
    @Autowired
    lateinit var userRepository: UserRepository

    @Transactional
    fun createUser(email: String, firstName: String, secondName: String): UserDTO {
        val existedUser: User? = userRepository.findByEmail(email);
        if (existedUser == null) {
            val user = User(email = email, firstName = firstName, lastName = secondName)
            userRepository.save(user)
            return UserDTO.fromEntity(user, Collections.emptyList())
        } else {
            throw BusinessLogicException("User with email = $email already exists")
        }
    }

    fun findUserByEmail(email: String): User? {
        return userRepository.findByEmail(email)

    }

    fun geAllUsers(): List<User> {
        return userRepository.findAll()
    }

    @Transactional
    fun deleteUserByEmail(email: String) {
        userRepository.deleteByEmail(email)
    }
}
