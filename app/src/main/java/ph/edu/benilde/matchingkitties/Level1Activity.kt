package ph.edu.benilde.matchingkitties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import androidx.activity.viewModels
import ph.edu.benilde.matchingkitties.databinding.ActivityLevel1Binding
import ph.edu.benilde.matchingkitties.viewModels.GameModes
import ph.edu.benilde.matchingkitties.viewModels.GameSize
import ph.edu.benilde.matchingkitties.viewModels.GameViewModel

class Level1Activity: AppCompatActivity(){
    private lateinit var binding: ActivityLevel1Binding
    private val imgButtons by lazy { listOf(
            binding.imgButton0,
            binding.imgButton1,
            binding.imgButton2,
            binding.imgButton3,
            binding.imgButton4,
            binding.imgButton5
    )
    }
    private val txtCountdown by lazy { binding.txtCountDown }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityLevel1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            this.supportActionBar?.hide();
        }

        val gameModel by viewModels<GameViewModel>()
        val gvmMode = intent.getIntExtra("GVM-mode", 0)
        val gvmModeUnit = when(gvmMode) {
            1 -> GameModes.MODE_ARCADE
            2 -> GameModes.MODE_MANIA
            else -> GameModes.MODE_NONE
        }

        val gvmSize = intent.getIntExtra("GVM-size", 0)
        val gameSizeUnit = when(gvmSize) {
            1 -> GameSize.SIZE_1
            2 -> GameSize.SIZE_2
            3 -> GameSize.SIZE_3
            else -> GameSize.SIZE_0
        }

        if(gvmModeUnit != GameModes.MODE_MANIA) { txtCountdown.visibility = GONE }
        Log.i("GAME", gameModel.gameMode.value!!.toString())
        gameModel.setGameMode(gvmModeUnit)
        gameModel.setGameSize(gameSizeUnit)
        gameModel.startGame()

        for(i in imgButtons.indices) { imgButtons[i].setOnClickListener { gameModel.checkOrSelect(i) } }
        gameModel.gameRoundImageStatus.observe(this) { refreshGrid() }
        gameModel.isDone.observe(this) {
            if(it == true) {
                if (gvmModeUnit == GameModes.MODE_ARCADE) {
                    val intent = Intent(this, ArcadeResultActivity::class.java)
                    intent.putExtra("GVM-mode", gvmMode)
                    intent.putExtra("GVM-size", gvmSize)
                    startActivityForResult(intent, 1)
                    finish()
                }

                if (gvmModeUnit == GameModes.MODE_MANIA) {

                }
            }
        }
    }

    private fun refreshGrid() {
        val gameModel by viewModels<GameViewModel>()
        val gameRoundImages = gameModel.gameRoundImages.value!!
        val gameRoundImageStatus = gameModel.gameRoundImageStatus.value!!

        for ( i in imgButtons.indices) {
            if(gameRoundImageStatus[i]) imgButtons[i].setBackgroundResource(gameRoundImages[i])
            else imgButtons[i].setBackgroundResource(R.drawable.kitty_00)
        }
    }
}