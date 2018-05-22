package ru.siksmfp.leardocker.server.controller;

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.siksmfp.leardocker.server.model.Message
import ru.siksmfp.leardocker.server.repository.Repository
import java.util.*

/**
 * @author Artem Karnov @date 11/6/2017.
 * artem.karnov@t-systems.com
 */
@RestController
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
