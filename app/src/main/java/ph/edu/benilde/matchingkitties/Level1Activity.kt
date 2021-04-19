package ph.edu.benilde.matchingkitties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ph.edu.benilde.matchingkitties.databinding.ActivityLevel1Binding
import ph.edu.benilde.matchingkitties.viewModels.GameViewModel

class Level1Activity: AppCompatActivity(){
    private lateinit var binding: ActivityLevel1Binding
    private val imgButton by lazy { listOf(
            binding.imgButton0,
            binding.imgButton1,
            binding.imgButton2,
            binding.imgButton3,
            binding.imgButton4,
            binding.imgButton5
        )
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityLevel1Binding.inflate(layoutInflater)
        setContentView(R.layout.activity_level1)

        if (supportActionBar != null) {
            this.supportActionBar?.hide();
        }

        val gameModel by viewModels<GameViewModel>()

    }
}
