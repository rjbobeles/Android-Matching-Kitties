package ph.edu.benilde.matchingkitties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import ph.edu.benilde.matchingkitties.databinding.ActivityLevel1Binding

private const val LOG_TAG = "Level1"

class Level1Activity: AppCompatActivity(){
    private lateinit var binding: ActivityLevel1Binding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityLevel1Binding.inflate(layoutInflater)
        setContentView(R.layout.activity_level1)

        if (supportActionBar != null) {
            this.supportActionBar?.hide();
        }
    }

}
