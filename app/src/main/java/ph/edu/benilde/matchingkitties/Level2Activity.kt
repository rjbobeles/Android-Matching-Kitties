package ph.edu.benilde.matchingkitties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ph.edu.benilde.matchingkitties.databinding.ActivityLevel2Binding
import ph.edu.benilde.matchingkitties.viewModels.GameViewModel

class Level2Activity: AppCompatActivity(){
    private lateinit var binding: ActivityLevel2Binding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityLevel2Binding.inflate(layoutInflater)
        setContentView(R.layout.activity_level2)

        if (supportActionBar != null) {
            this.supportActionBar?.hide();
        }

        val gameModel by viewModels<GameViewModel>()
    }
}
