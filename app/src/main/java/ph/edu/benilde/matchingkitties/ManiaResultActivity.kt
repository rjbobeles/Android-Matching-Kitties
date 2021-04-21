package ph.edu.benilde.matchingkitties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.edu.benilde.matchingkitties.databinding.ActivityManiaResultBinding
import kotlin.random.Random

class ManiaResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManiaResultBinding

    private val btnPlayAgain by lazy { binding.btnPlayAgain }
    private val btnMenu by lazy { binding.btnMenu }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManiaResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val score = intent.getIntExtra("GVM-User-Score", 0)
        binding.txtScore.text = score.toString()

        btnPlayAgain.setOnClickListener {
            val level = Random.nextInt(1, 4)
            val levelClass = when(level) {
                1 -> Level1Activity::class.java
                2 -> Level2Activity::class.java
                3 -> Level3Activity::class.java
                else -> null
            }

            val intent = Intent(this, levelClass)
            intent.putExtra("GVM-mode", 2)
            intent.putExtra("GVM-size", level)
            intent.putExtra("GVM-User-Time", 31000)
            intent.putExtra("GVM-User-Score", 0)
            startActivityForResult(intent, 1)
        }

        btnMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}