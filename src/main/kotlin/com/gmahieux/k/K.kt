package com.gmahieux.k

import com.gmahieux.k.data.Quotes
import com.gmahieux.k.model.Quote
import com.google.gson.Gson
import com.mongodb.MongoCredential
import com.mongodb.ServerAddress
import com.mongodb.client.MongoCollection
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.litote.kmongo.KMongo
import org.litote.kmongo.MongoOperator.sample
import org.litote.kmongo.aggregate
import org.litote.kmongo.getCollection
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
        routing {
            get("/") {

                call.respondText("Hello World!", ContentType.Text.Plain)
            }
            get("/quote") {
                val quote = col.aggregate<Quote>("""[{ ${sample}: { size: 1 } }]""").first()
                call.respondText(
                    contentType = ContentType.Application.Json,
                    text = Gson().toJson(quote, Quote::class.java)
                )
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

