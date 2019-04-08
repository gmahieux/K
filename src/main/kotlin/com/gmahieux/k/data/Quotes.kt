package com.gmahieux.k.data

import com.gmahieux.k.model.Quote
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.time.Instant
import kotlin.random.Random

class Quotes {

    val listType = object : TypeToken<List<Quote>>() { }.type

    val quotes = Gson().fromJson<List<Quote>>(Quotes::class.java.getResource("/citations.json").readText(), listType)

    fun getRandomQuote() =quotes[Random(Instant.now().epochSecond).nextInt(0,quotes.size)]


}
