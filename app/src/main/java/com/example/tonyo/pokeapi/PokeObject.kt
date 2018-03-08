package com.example.tonyo.pokeapi

/**
 * Created by TONYO on 3/8/2018.
 */

data class PokeObject (
        val id: Int,
        val name: String,
        val sprites: Sprites
)
data class Sprites(
        val front_default: String
)