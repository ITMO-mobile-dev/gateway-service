package ru.ifmo

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.JsonObject

fun Application.configureRouting() {
    routing {
        get("/api/hello") {
            call.respond(Response("Hello from gateway-service"))

        }

        post("api/register") {
            val jsonData: JsonObject = call.receive()

            val response: String = client.post("http://localhost:8080/register") {
                contentType(ContentType.Application.Json)
                setBody(jsonData)
            }.bodyAsText()

            call.respondText(response)
        }

        post("api/login") {
            val jsonData: JsonObject = call.receive()

            val response: String = client.post("http://localhost:8080/login") {
                contentType(ContentType.Application.Json)
                setBody(jsonData)
            }.bodyAsText()

            // Отправляем ответ обратно
            call.respondText(response)
        }
    }
}
