package ru.orbot90.com.coc.gmhelper.core

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class HelperApplication {

}

fun main(args: Array<String>) {
    SpringApplication.run(HelperApplication::class.java, *args)
}