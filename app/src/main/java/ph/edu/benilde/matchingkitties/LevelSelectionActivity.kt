package ph.edu.benilde.matchingkitties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ph.edu.benilde.matchingkitties.databinding.ActivityLevelSelectionBinding
import ph.edu.benilde.matchingkitties.viewModels.GameModes
import ph.edu.benilde.matchingkitties.viewModels.GameSize
import ph.edu.benilde.matchingkitties.viewModels.GameViewModel

class LevelSelectionActivity: AppCompatActivity() {

    private lateinit var binding: ActivityLevelSelectionBinding

    private val btnClose by lazy { binding.btnClose }
    private val btnLvl1 by lazy { binding.btnLvl1 }
    private val btnLvl2 by lazy { binding.btnLvl2 }
    private val btnLvl3 by lazy { binding.btnLvl3 }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLevelSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            this.supportActionBar?.hide();
        }

        val gameModel by viewModels<GameViewModel>()

        btnLvl1.setOnClickListener {
            val intent = Intent(this, Level1Activity::class.java)
            intent.putExtra("GVM-mode", 1)
            intent.putExtra("GVM-size", 1)
            startActivityForResult(intent, 1)
        }

        btnLvl2.setOnClickListener {
            val intent = Intent(this, Level2Activity::class.java)
            intent.putExtra("GVM-mode", 1)
            intent.putExtra("GVM-size", 2)
            startActivityForResult(intent, 1)
        }

        btnLvl3.setOnClickListener {
            val intent = Intent(this, Level3Activity::class.java)
            intent.putExtra("GVM-mode", 1)
            intent.putExtra("GVM-size", 3)
            startActivityForResult(intent, 1)
        }

        btnClose.setOnClickListener{
            finish()
        }

    }
}