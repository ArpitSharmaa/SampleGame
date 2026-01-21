package com.netomi.samplegame

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MemoryGameViewModel : ViewModel() {

    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> = _gameState.asStateFlow()

    companion object {
        private const val CARD_PAIRS = 8
    }

    init {
        initializeGame()
    }

    fun initializeGame() {
        val cardValues = List(CARD_PAIRS) { it + 1 }
        val pairedCards = cardValues + cardValues
        val shuffledCards = pairedCards.shuffled().mapIndexed { index, value ->
            Card(id = index, value = value)
        }
        _gameState.value = GameState(cards = shuffledCards)
    }

    fun onCardClick(cardId: Int) {
    }

    fun resetGame() {
        initializeGame()
        _gameState.value = _gameState.value.copy(
            isGameComplete = false,
            canFlipCard = true
        )
    }
}
