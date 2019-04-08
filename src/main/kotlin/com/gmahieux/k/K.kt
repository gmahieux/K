package com.gmahieux.k

import com.gmahieux.k.data.Quotes
import com.gmahieux.k.model.Quote
import com.mongodb.MongoCredential
import com.mongodb.ServerAddress
import com.mongodb.client.MongoCollection
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.content.default
import io.ktor.http.content.files
import io.ktor.http.content.static
import io.ktor.http.content.staticRootFolder
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.litote.kmongo.KMongo
import org.litote.kmongo.MongoOperator.match
import org.litote.kmongo.MongoOperator.sample
import org.litote.kmongo.aggregate
import org.litote.kmongo.getCollection
import java.io.File
import java.util.Arrays.asList

fun main() {
    val quotes = Quotes()


    val client = KMongo.createClient(
        ServerAddress(System.getenv("MONGO_HOST"), System.getenv("MONGO_PORT").toInt()),
        asList(
            MongoCredential.createCredential(
                System.getenv("MONGO_USER"),
                "admin",
                System.getenv("MONGO_PWD").toCharArray()
            )
        )
    )
    val database = client.getDatabase("k")
    val col = database.getCollection<Quote>()
    insertQuoteIfMissing(col, quotes)

    val server = embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            gson { }
        }
        routing {
            static("") {
                staticRootFolder = File("/www")
                static("img") {
                    files("img")
                }
                default("index.html")
            }
            get("/quote") {
                throw NullPointerException()
            }
            get("/quote/{character}") {
                val character = call.parameters["character"]
                val quote = col.aggregate<Quote>("""[{ $match: { "refs.character": "$character" } }, { $sample: { size: 1 } }]""").first()
                call.respond(quote)
            }
        }
    }
    server.start(wait = true)
}

private fun insertQuoteIfMissing(
    col: MongoCollection<Quote>,
    quotes: Quotes
) {
    if (col.countDocuments() == 0L) {
        col.insertMany(quotes.quotes)
    }
}

