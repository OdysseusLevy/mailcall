package org.mailcall

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class MailcallApplication

fun main(args: Array<String>) {
    SpringApplication.run(MailcallApplication::class.java, *args)
}
