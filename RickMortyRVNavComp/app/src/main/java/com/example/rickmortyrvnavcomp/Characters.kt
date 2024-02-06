package com.example.rickmortyrvnavcomp

import java.io.Serializable

data class Characters(
    val image: Int,
    val lifeStatus: String,
    val name: String
) : Serializable
