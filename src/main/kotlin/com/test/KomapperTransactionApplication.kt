package com.test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KomapperTransactionApplication

fun main(args: Array<String>) {
	runApplication<KomapperTransactionApplication>(*args)
}
