package ph.edu.benilde.matchingkitties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import ph.edu.benilde.matchingkitties.databinding.ActivityLevel3Binding

private const val LOG_TAG = "Level3"

class Level3Activity: AppCompatActivity() {
    private lateinit var binding: ActivityLevel3Binding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityLevel3Binding.inflate(layoutInflater)
        setContentView(R.layout.activity_level3)

        if (supportActionBar != null) {
            this.supportActionBar?.hide();
        }
    }
}