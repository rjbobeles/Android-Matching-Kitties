package ph.edu.benilde.matchingkitties.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ph.edu.benilde.matchingkitties.R
import java.util.*
import kotlin.concurrent.schedule
import kotlin.random.Random

class GameViewModel: ViewModel() {
    private val _inGame = MutableLiveData<Boolean>(false)
    private val _isDone = MutableLiveData<Boolean>(false)
    private val _gameStarted = MutableLiveData<Boolean>(false)
    private val _gameMode = MutableLiveData<GameModes>(GameModes.MODE_NONE)
    private val _gameSize = MutableLiveData<GameSize>(GameSize.SIZE_0)

    private val _gameImages = MutableLiveData<IntArray>()
    private val _gameRoundImages = MutableLiveData<IntArray>()
    private val _gameRoundImageStatus = MutableLiveData<BooleanArray>()
    private val _openedImages = MutableLiveData<Int>(0)

    private val _hasSelected = MutableLiveData<Int>(-1)
    private val _score = MutableLiveData<Int>(-1)
    private val _timeLeft = MutableLiveData<Int>(-1)

    private val imageArray = mutableListOf<Int>(
        R.drawable.kitty_01, R.drawable.kitty_02, R.drawable.kitty_03,
        R.drawable.kitty_04, R.drawable.kitty_05, R.drawable.kitty_06,
        R.drawable.kitty_07, R.drawable.kitty_08, R.drawable.kitty_09,
        R.drawable.kitty_10, R.drawable.kitty_11, R.drawable.kitty_12,
        R.drawable.kitty_13, R.drawable.kitty_14, R.drawable.kitty_15
    )

    val inGame: LiveData<Boolean> = _inGame
    val isDone: LiveData<Boolean> = _isDone
    val gameStarted: LiveData<Boolean> = _gameStarted
    val gameMode: LiveData<GameModes> = _gameMode
    val gameSize: LiveData<GameSize> = _gameSize

    val gameRoundImages: LiveData<IntArray> = _gameRoundImages
    val gameRoundImageStatus: LiveData<BooleanArray> = _gameRoundImageStatus

    val score: LiveData<Int> = _score
    val timeLeft: LiveData<Int> = _timeLeft

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
        _gameStarted.value = false
        _gameMode.value = GameModes.MODE_NONE
        _gameSize.value = GameSize.SIZE_0

        _gameImages.value = null
        _gameRoundImages.value = null
        _gameRoundImageStatus.value = null
        _openedImages.value = 0

        _hasSelected.value = -1
        _score.value = 0
        _timeLeft.value = 0
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
                Timer().schedule(1000) {
                    _gameRoundImageStatus.value!![_hasSelected.value!!] = false
                    _gameRoundImageStatus.value!![box] = false

                    _hasSelected.value = -1
                }
            }
        }

        if(_openedImages.value!! == _gameImages.value!!.size) {
            _isDone.value = true
            _inGame.value = false

            if(_gameMode.value!! != GameModes.MODE_MANIA) {
                _gameStarted.value = false
            }
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