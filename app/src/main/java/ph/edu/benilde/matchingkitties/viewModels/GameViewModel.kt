package ph.edu.benilde.matchingkitties.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ph.edu.benilde.matchingkitties.R
import kotlin.random.Random

class GameViewModel: ViewModel() {
    private var _inGame = MutableLiveData<Boolean>(false)
    private var _isDone = MutableLiveData<Boolean>(false)
    private var _gameStarted = MutableLiveData<Boolean>(false)
    private var _gameMode = MutableLiveData<GameModes>(GameModes.MODE_NONE)
    private var _gameSize = MutableLiveData<GameSize>(GameSize.SIZE_0)

    private var _gameImages = MutableLiveData<IntArray>()
    private var _gameRoundImages = MutableLiveData<IntArray>()
    private var _gameRoundImageStatus = MutableLiveData<BooleanArray>()
    private var _openedImages = MutableLiveData<Int>(0)

    private var _hasSelected = MutableLiveData<Int>(-1)
    private var _score = MutableLiveData<Int>(-1)
    private var _timeLeft = MutableLiveData<Int>(-1)

    private var imageArray = mutableListOf<Int>(
        R.drawable.kitty_01, R.drawable.kitty_02, R.drawable.kitty_03,
        R.drawable.kitty_04, R.drawable.kitty_05, R.drawable.kitty_06,
        R.drawable.kitty_07, R.drawable.kitty_08, R.drawable.kitty_09,
        R.drawable.kitty_10, R.drawable.kitty_11, R.drawable.kitty_12,
        R.drawable.kitty_13, R.drawable.kitty_14, R.drawable.kitty_15
    )

    // Todo: TIMER FOR TIME LEFT

    init { }

    fun setMode(mode: GameModes) {
        if(_inGame.value!! || _gameStarted.value!!) return
        _gameMode.value = mode
    }

    fun setGameSize(size: GameSize) {
        if(_inGame.value!! || _gameStarted.value!!) return
        if(_gameMode.value!! != GameModes.MODE_ARCADE) return
        _gameSize.value = size
    }

    fun startGame() {
        if(_gameMode.value!! == GameModes.MODE_NONE) return

        _isDone.value = false

        if(_gameMode.value!! == GameModes.MODE_ARCADE) {
            if(_gameSize.value!! == GameSize.SIZE_0) return
            generateLevel()
        }

        if(_gameMode!!.equals(GameModes.MODE_MANIA)) { generateLevel() }

        _inGame.value = true
    }

    fun stopGame() {
        _isDone.value = false
        _inGame.value = false
        _gameMode.value = GameModes.MODE_NONE
        _gameSize.value = GameSize.SIZE_0
        _gameStarted.value = false
        _score.value = 0
        _timeLeft.value = 0
        // Todo: Clear Variables
    }

    fun checkOrSelect(box: Int) {
        if(_hasSelected.value == -1) {
            _hasSelected.value = box
            _gameRoundImageStatus.value!![box] = true
            return
        } else {
            _gameRoundImageStatus.value!![box] = true

            if(_gameRoundImages.value!![_hasSelected.value!!] == _gameRoundImages.value!![box]) {
                _hasSelected.value = -1
                _openedImages.value = _openedImages.value!! + 1

                if(_gameMode.value!! == GameModes.MODE_MANIA) {
                    // Todo: add Points, Time
                }
            } else {
                _hasSelected.value = -1
                _gameRoundImageStatus.value!![_hasSelected.value!!] = false
                _gameRoundImageStatus.value!![box] = false

                // Todo: Timeout to clear images
            }
        }

        if(_openedImages.value!! == _gameImages.value!!.size) {
            _isDone.value = true
            // Todo: Show Final score
        }
    }

    private fun generateLevel() {
        if(_gameMode.value!! == GameModes.MODE_MANIA) {
            val r = Random.nextInt(3, 5)
            _gameSize.value = when(r) {
                3 -> GameSize.SIZE_1
                4 -> GameSize.SIZE_2
                5 -> GameSize.SIZE_3
                else -> GameSize.SIZE_0
            }
        }

        val uniqueItems = when(_gameSize.value!!) {
            GameSize.SIZE_1 -> 3
            GameSize.SIZE_2 -> 4
            GameSize.SIZE_3 -> 5
            else -> 0
        }

        val shuffledCards = imageArray.shuffled()
        _gameImages.value = shuffledCards.take(uniqueItems).toIntArray()

        val roundCards = _gameImages.value!! + _gameImages.value!!
        val shuffledRoundCards = roundCards.toMutableList().shuffled()
        _gameRoundImages.value = shuffledRoundCards.toIntArray()

        _gameRoundImageStatus.value = BooleanArray(uniqueItems * 2)
    }
}


enum class GameModes { MODE_NONE, MODE_ARCADE, MODE_MANIA }

enum class GameSize { SIZE_0, SIZE_1, SIZE_2, SIZE_3 }