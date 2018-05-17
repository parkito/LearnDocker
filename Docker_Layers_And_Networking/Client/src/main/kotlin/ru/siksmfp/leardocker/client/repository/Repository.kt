package ru.siksmfp.leardocker.client.repository

import ru.siksmfp.leardocker.client.model.Message

/**
 * @author Artem Karnov @date 5/17/2018.
 * @email  artem.karnov@t-systems.com
 */
class Repository {
    var messages: MutableList<Message> = mutableListOf()

    fun saveMessage(message: Message) {
        messages.add(message)
    }

    fun getAllMessages(): List<Message> {
        return messages
    }
}