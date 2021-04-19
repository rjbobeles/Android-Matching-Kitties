package ph.edu.benilde.matchingkitties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.edu.benilde.matchingkitties.databinding.ActivityArcadeResultBinding
import kotlin.random.Random

class ArcadeResultActivity : AppCompatActivity() {
    private lateinit var binding:ActivityArcadeResultBinding
    private val phrases = listOf("You did great!", "Good job!", "Well done!")

    private val btnPlayAgain by lazy { binding.btnPlayAgain }
    private val btnMenu by lazy { binding.btnMenu }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArcadeResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val phrase = phrases[Random.nextInt(0, 2)]
        binding.txtMessage.text = phrase

        /*
        Get whatever level was played and play that again
        btnPlayAgain.setOnClickListener {
            val intent = Intent(this, ...)
            startActivity(intent)
        }

         */

        btnMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

    }
}