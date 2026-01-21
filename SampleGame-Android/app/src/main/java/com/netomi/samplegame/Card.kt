package com.netomi.samplegame

data class Card(
    val id: Int,
    val value: Int,
    val isFlipped: Boolean = false,
    val isMatched: Boolean = false
)

