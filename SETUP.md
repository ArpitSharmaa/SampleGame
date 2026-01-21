# Setup Instructions

## Build Issues - Quick Fix

If you see build errors about duplicate classes, please do the following:

### Option 1: Use Android Studio (Recommended)
1. Open the project in Android Studio
2. Click **File → Invalidate Caches / Restart → Invalidate and Restart**
3. After restart, click **Build → Clean Project**
4. Then click **Build → Rebuild Project**

### Option 2: Manual Cleanup
Delete these old duplicate files if they exist:
- `app/src/main/java/com/netomi/samplegame/Card.kt`
- `app/src/main/java/com/netomi/samplegame/GameState.kt`  
- `app/src/main/java/com/netomi/samplegame/MemoryGameViewModel.kt`
- `app/src/main/java/com/netomi/samplegame/FlipCard.kt`
- `app/src/main/java/com/netomi/samplegame/ui/screens/` folder

**Keep only these files:**
- ✅ `MemoryGame.kt` (contains all game logic)
- ✅ `MainActivity.kt`
- ✅ `ui/theme/` folder (theme files)

### Option 3: Gradle Clean
From terminal in project root:
```bash
./gradlew clean
./gradlew build
```

## Project Structure

The entire game is now in a single file for simplicity:

```
app/src/main/java/com/netomi/samplegame/
├── MemoryGame.kt     ← ALL GAME CODE HERE
├── MainActivity.kt   ← Entry point
└── ui/theme/         ← Theme only
```

## How the Game Works

**MemoryGame.kt** contains:
1. **Data Models**: `Card` and `GameState`
2. **ViewModel**: `MemoryGameViewModel` with full business logic
3. **UI Components**: `MemoryGameScreen` and `FlipCard`

Everything is properly organized within one file following MVVM architecture.
