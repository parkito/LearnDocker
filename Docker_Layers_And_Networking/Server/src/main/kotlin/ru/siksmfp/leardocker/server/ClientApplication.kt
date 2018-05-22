package ru.siksmfp.leardocker.server;

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Configuration

@Configuration
@SpringBootApplication
class UserApplication {
}

fun main(args: Array<String>) {
    SpringApplication.run(UserApplication::class.java, *args);
}