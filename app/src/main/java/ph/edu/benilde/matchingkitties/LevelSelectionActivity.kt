package ph.edu.benilde.matchingkitties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.edu.benilde.matchingkitties.databinding.ActivityLevelSelectionBinding

class LevelSelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLevelSelectionBinding

    private val btnClose by lazy { binding.btnClose }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLevelSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Remove title bar
        if (supportActionBar != null) {
            this.supportActionBar?.hide();
        }

        btnClose.setOnClickListener{
            finish()
        }

    }
}