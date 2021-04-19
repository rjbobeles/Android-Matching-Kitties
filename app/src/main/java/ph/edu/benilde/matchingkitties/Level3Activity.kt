package ph.edu.benilde.matchingkitties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ph.edu.benilde.matchingkitties.databinding.ActivityLevel3Binding
import ph.edu.benilde.matchingkitties.viewModels.GameViewModel

class Level3Activity: AppCompatActivity() {
    private lateinit var binding: ActivityLevel3Binding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityLevel3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            this.supportActionBar?.hide();
        }

        val gameModel by viewModels<GameViewModel>()
    }
}