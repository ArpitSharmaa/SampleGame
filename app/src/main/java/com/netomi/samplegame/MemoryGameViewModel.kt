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
        if (!_gameState.value.canFlipCard || _gameState.value.isGameComplete) return

        val card = _gameState.value.cards.firstOrNull { it.id == cardId } ?: return
        if (card.isMatched) return
        flipCard(cardId)
    }

    fun flipCard(cardId: Int) {

        val current = _gameState.value

        val updatedCards = current.cards.map { card ->
            if (card.id == cardId) {
                card.copy(isFlipped = !card.isFlipped)
            } else card
        }

        val flippedUnmatched = updatedCards.filter { it.isFlipped && !it.isMatched }

        _gameState.value = current.copy(
            cards = updatedCards,
            canFlipCard = flippedUnmatched.size < 2,
            moves = current.moves + 1
        )

        if (flippedUnmatched.size == 2) {
            val first = flippedUnmatched[0]
            val second = flippedUnmatched[1]

            viewModelScope.launch {
                delay(500)

                val isMatch = first.value == second.value

                val resolvedCards = _gameState.value.cards.map { card ->
                    when (card.id) {
                        first.id, second.id ->
                            if (isMatch)
                                card.copy(isMatched = true, isFlipped = true)
                            else
                                card.copy(isFlipped = false)
                        else -> card
                    }
                }

                val matchedCount = resolvedCards.count { it.isMatched }

                _gameState.value = _gameState.value.copy(
                    cards = resolvedCards,
                    canFlipCard = true,
                    isGameComplete = matchedCount == CARD_PAIRS * 2
                )
            }
        }
    }

    fun resetGame() {
        initializeGame()
        _gameState.value = _gameState.value.copy(
            isGameComplete = false,
            canFlipCard = true
        )
    }
}
