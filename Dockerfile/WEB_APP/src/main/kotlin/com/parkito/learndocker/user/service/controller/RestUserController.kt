package com.parkito.learndocker.user.service.controller;

import com.parkito.learndocker.user.service.dto.UserDTO
import com.parkito.learndocker.user.service.entity.User
import com.parkito.learndocker.user.service.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * @author Artem Karnov @date 11/6/2017.
 * artem.karnov@t-systems.com
 */
@RestController
@RequestMapping("/api/v1")
class RestUserController {
    val logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/create-user")
    fun createUser(@RequestParam email: String,
                   @RequestParam firstName: String,
                   @RequestParam secondName: String): ResponseEntity<UserDTO> {
        logger.info("In createUser(email = {}, firstName = {}, secondName = {})", email, firstName, secondName);
        val user: UserDTO = userService.createUser(email, firstName, secondName);
        return ResponseEntity(user, HttpStatus.OK)
    }

    @GetMapping("/find-user")
    fun findUser(@RequestParam email: String): ResponseEntity<User?> {
        logger.info("In findUser(email = {})", email);
        return ResponseEntity(userService.findUserByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/delete-user")
    fun deleteUser(@RequestParam email: String): ResponseEntity<Boolean> {
        logger.info("In deleteUser(email = {})", email);
        userService.deleteUserByEmail(email);
        return ResponseEntity(true, HttpStatus.OK)
    }

    @GetMapping("/get-all")
    fun getAllUsers(): List<User> {
        logger.info("In getAllUsers()");
        return userService.geAllUsers()
    }
}
