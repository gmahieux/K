package com.gmahieux.k.model

data class Quote(val quote: String, val refs: Infos)

data class Infos(val actor: String, val character : String, val season : String, val episode : String)

