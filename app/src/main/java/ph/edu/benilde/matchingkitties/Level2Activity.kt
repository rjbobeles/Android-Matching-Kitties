package ph.edu.benilde.matchingkitties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import ph.edu.benilde.matchingkitties.databinding.ActivityLevel2Binding

private const val LOG_TAG = "Level2"

class Level2Activity: AppCompatActivity(){
    private lateinit var binding: ActivityLevel2Binding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityLevel2Binding.inflate(layoutInflater)
        setContentView(R.layout.activity_level2)

        if (supportActionBar != null) {
            this.supportActionBar?.hide();
        }
    }
}
