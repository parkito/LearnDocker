package ru.siksmfp.leardocker.client.controller;

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
import java.io.File
import java.io.PrintWriter
import java.net.URI

/**
 * @author Artem Karnov @date 11/6/2017.
 * artem.karnov@t-systems.com
 */
@RestController
@RequestMapping("/api/v1")
class ClientController {
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
            return handleException(ex)
        }
    }

    @GetMapping("/saveFile")
    fun saveFile(@RequestParam path: String,
                 @RequestParam fileName: String,
                 @RequestParam message: String): String {
        val file = File("$path$fileName.txt")
        val pw = PrintWriter(file.absoluteFile)
        try {
            if (!file.exists()) {
                file.createNewFile()
            }
            pw.print(message)
        } catch (ex: Exception) {
            return handleException(ex)
        } finally {
            pw.close()
        }

        return "SUCCESS"
    }

    fun handleException(ex: Exception): String {
        val error = StringBuilder()
        for (st in ex.stackTrace) {
            error.append(st.toString()).append("\n")
        }
        LOGGER.error(ex.toString())
        return "Something wrong \n" + error.toString()
    }
}
