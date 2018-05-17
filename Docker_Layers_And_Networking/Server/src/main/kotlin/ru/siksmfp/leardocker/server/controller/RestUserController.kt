package ru.siksmfp.leardocker.server.controller;

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

/**
 * @author Artem Karnov @date 11/6/2017.
 * artem.karnov@t-systems.com
 */
@RestController
@RequestMapping("/api/v1")
class RestUserController {
    val LOGGER = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var restTemplate: RestTemplate

    @GetMapping("/sendMessage")
    fun sendMessage(@RequestParam address: String,
                    @RequestParam message: String): String {
        val targetUrl: URI = UriComponentsBuilder
                .fromHttpUrl(address)
                .pathSegment("end-point")
                .queryParam("message", message)
                .build().toUri();

        try {
            return restTemplate.exchange(targetUrl, HttpMethod.GET, HttpEntity.EMPTY, String::class.java).body
        } catch (ex: Exception) {
            return "Something wrong " + ex.stackTrace
        }
    }

    @GetMapping("/saveFile")
    fun saveFile(fileName: String, message: String): String {
        return ""
    }
}
