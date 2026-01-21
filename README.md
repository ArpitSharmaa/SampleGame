# Memory Flip Game (Android)

## Overview

This project is a small Android application that implements a classic **Memory / Concentration** card game.

The UI is intentionally simple. The focus of this exercise is **game logic, state management, and architectural clarity**, structured across multiple files to resemble a real-world Android codebase.

Your task is to review the existing implementation and make the game behave **correctly and consistently** according to the rules described below.

---

## Game Rules

The expected behavior of the game is as follows:

1. The game consists of **pairs of matching cards**.

2. All cards start **face down**.

3. When a card is tapped:

    * If the card is already **face up** or **matched**, the tap has **no effect**.
    * If **no other unmatched card** is currently face up:

        * The selected card flips face up.
    * If **exactly one unmatched card** is already face up:

        * If the two cards **match**:

            * Both cards become **matched** and remain face up permanently.
        * If the two cards **do not match**:

            * Both cards remain visible for **500 milliseconds**.
            * After the delay, both cards automatically flip back face down.
    * While **two unmatched cards are visible** (during the 500ms delay):

        * All additional taps must be **ignored**.

4. **Matched cards must never flip back down**.

5. The game is considered **complete** when **all cards are matched**.

6. Tapping **Reset** should restart the game cleanly to its initial state.

---

## Moves

A **move** is defined as a single **pair attempt**
(i.e., when the second card of a pair is flipped).

---

## Project Structure

* **Model**

    * Represents a card and its state (face-down, face-up, matched)

* **ViewModel**

    * Holds all game logic
    * Exposes state via `StateFlow`
    * Handles timing and user interaction rules

* **UI (Jetpack Compose)**

    * Displays the card grid
    * Observes ViewModel state
    * Contains no game logic

---

## Expectations

We are primarily interested in:

* Clear and correct game logic
* Clean, readable code
* Thoughtful state handling
* Sensible separation of responsibilities

You do **not** need to:

* Redesign the UI
* Add animations or sound effects
* Add persistence
* Introduce third-party libraries

---

## Target Platform & Constraints

* Android Studio **Arctic Fox (2020.3.1)** or later
* Kotlin **1.5+**
* Jetpack Compose enabled
* Minimum SDK: **API 21 (Android 5.0)**
* Emulator or physical device

---

## Deliverables

Please provide:

1. A **working version** of the project
2. A short explanation (**1–2 paragraphs**) describing:

    * What you changed
    * Why you made those changes

---

## Time Guideline

This task is designed to be completed within **~60 minutes**.

Focus on:

* Correctness
* Clarity
* Maintainability

Polish and extra features are **not required**.

---

## Notes

If you encounter any ambiguity, choose the solution that feels **most intuitive to a player** and briefly document your reasoning in your explanation.

---

## Technologies Used

* Kotlin
* Jetpack Compose
* Material 3
* ViewModel
* StateFlow
* Coroutines
* JUnit (optional)

---