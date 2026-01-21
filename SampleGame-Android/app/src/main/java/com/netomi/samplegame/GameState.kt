package com.netomi.samplegame

data class GameState(
    val cards: List<Card> = emptyList(),
    val moves: Int = 0,
    val isGameComplete: Boolean = false,
    val canFlipCard: Boolean = true
)
