package com.gmahieux.k

import com.gmahieux.k.data.Quotes
import com.gmahieux.k.model.Quote
import com.google.gson.Gson
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    val quotes = Quotes()

    val server = embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {

                call.respondText("Hello World!", ContentType.Text.Plain)
            }
            get("/quote") {
                call.respondText(
                    contentType = ContentType.Application.Json,
                    text = Gson().toJson(quotes.getRandomQuote(), Quote::class.java)
                )
            }
        }
    }
    server.start(wait = true)
}

