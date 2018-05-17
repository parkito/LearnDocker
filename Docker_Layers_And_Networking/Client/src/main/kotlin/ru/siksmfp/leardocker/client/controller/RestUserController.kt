package ru.siksmfp.leardocker.client.controller;

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.siksmfp.leardocker.client.model.Message
import ru.siksmfp.leardocker.client.repository.Repository
import java.util.*

/**
 * @author Artem Karnov @date 11/6/2017.
 * artem.karnov@t-systems.com
 */
@RestController
@RequestMapping("/api/v1")
class RestUserController {
    val LOGGER = LoggerFactory.getLogger(javaClass)
    val repository: Repository = Repository()

    @GetMapping("/end-point")
    fun sendMessage(@RequestParam message: String): String {
        var messageObject: Message = Message(Date(), message)
        repository.saveMessage(messageObject)
        return "Message: $message received"
    }

    @GetMapping("/messages")
    fun saveFile(): List<Message> {
        return repository.getAllMessages()
    }
}
