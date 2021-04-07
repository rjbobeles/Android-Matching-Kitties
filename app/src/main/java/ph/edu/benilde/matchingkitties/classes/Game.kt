package ph.edu.benilde.matchingkitties.classes

class Game (gameMode: GameModes, gameSize: GameSize) {
    // Game
    private var gameStarted: Boolean = false
    private var gameMode: GameModes = gameMode
    private var gameSize: GameSize = gameSize

    // Current Game

    // Private Methods
    private fun nextLevel() {}

    private fun shuffleCards() {}
    
    // Public Methods
    fun startGame() {
        if(gameMode == GameModes.MODE_NONE) return

        if(gameMode == GameModes.MODE_ARCADE) { }
        if(gameMode == GameModes.MODE_MANIA) { }

        this.gameStarted = true
    }

    fun stopGame() {
        if(gameMode == GameModes.MODE_NONE) return
        this.gameStarted = false
    }

    fun validateSelection() {
        if(!this.gameStarted) return
    }
}

enum class GameModes { MODE_NONE, MODE_ARCADE, MODE_MANIA }

/**
 * Game Sizes:
 * SIZE_1: 2x3
 * SIZE_2: 2x4
 * SIZE_3: 2x5
 * */

enum class GameSize { SIZE_0, SIZE_1, SIZE_2, SIZE_3 }