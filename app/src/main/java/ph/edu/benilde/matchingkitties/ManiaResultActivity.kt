package ph.edu.benilde.matchingkitties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.edu.benilde.matchingkitties.databinding.ActivityManiaResultBinding

class ManiaResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManiaResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManiaResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val score = intent.getIntExtra("GVM-User-Score", 0)
        binding.txtScore.text = score.toString()
    }
}