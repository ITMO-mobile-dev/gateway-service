package ru.ifmo

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/api/hello") {
            call.respond(Response("Hello from gateway-service"))
        }
    }
}
