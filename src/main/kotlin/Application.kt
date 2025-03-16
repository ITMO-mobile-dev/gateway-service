package ru.ifmo

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.netty.*
import kotlinx.serialization.Serializable

/*
 Для теста просто, не ссыте
* */
@Serializable
data class Response(val msg: String)

val client = HttpClient {
    install(ContentNegotiation) {
        json()
    }
}

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    configureRouting()
    configureSerialization()
}
