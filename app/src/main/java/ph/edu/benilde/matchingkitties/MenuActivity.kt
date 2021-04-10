package ph.edu.benilde.matchingkitties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import ph.edu.benilde.matchingkitties.databinding.ActivityMenuBinding
import android.os.Bundle

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    private val btnCasual by lazy { binding.btnCasual }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Remove title bar
        if (supportActionBar != null) {
            this.supportActionBar?.hide();
        }

        btnCasual.setOnClickListener {
            val intent = Intent(this, LevelSelectionActivity::class.java)
            startActivity(intent)
        }
    }
}