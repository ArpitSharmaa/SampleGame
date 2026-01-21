# Memory Game - Android Interview Project

A Flip Card Memory Game built with **Kotlin** and **Jetpack Compose** following **MVVM architecture**.

---

## 🎮 Game Rules

1. **Setup**: All cards start face down in a 4x4 grid (16 cards total, 8 pairs)
2. **Gameplay**:
   - Tap a card to flip it and reveal its value
   - You can open only **two cards at a time**
   - If cards are already open or matched, tapping them does nothing
3. **Matching**:
   - If both cards have the **same value**, they stay open forever (matched)
   - If the cards are **different**, they stay open for **500ms** then flip back down
   - While two cards are open, you **cannot tap any other cards**
4. **End Game**: The game finishes when all card pairs are matched

---

## ⚠️ Implementation Task

Your task is to implement **three core functions** in `MemoryGameViewModel.kt`:

1. **`initializeGame()`** - Initialize and shuffle the card deck
2. **`onCardClick(cardId: Int)`** - Handle card flip logic and game rules
3. **`resetGame()`** - Reset the game to initial state

---

## 🚀 Getting Started

### Target Platform
**Android**: 
- Android Studio Arctic Fox (2020.3.1) or later
- Kotlin 1.5+
- Jetpack Compose enabled
- Emulator or physical device running Android API level 21 (Android 5.0) or higher

### Steps
1. Open the project in Android Studio
2. Explore the code structure
3. Implement the three functions in `MemoryGameViewModel.kt`
4. Run the app and test your implementation

---

## 🎯 Evaluation Criteria

- **Correctness**: Game logic works as per requirements, no crashes
- **Code Quality**: Clean, readable code with proper Kotlin idioms
- **Architecture Understanding**: Proper use of ViewModel and state management
- **Testing**: Thorough testing and edge case handling

---

## 🛠️ Technologies Used

- Kotlin
- Jetpack Compose
- Material 3
- ViewModel & StateFlow
- Coroutines

---

**Good luck! 🎮**
