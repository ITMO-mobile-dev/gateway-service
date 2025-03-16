package ru.ifmo

import io.ktor.server.application.*
import io.ktor.server.netty.*
import kotlinx.serialization.Serializable

/*
 Для теста просто, не ссыте
* */
@Serializable
data class Response(val msg: String)

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    configureRouting()
    configureSerialization()
}
