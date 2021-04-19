package ph.edu.benilde.matchingkitties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import ph.edu.benilde.matchingkitties.databinding.ActivityMenuBinding
import android.os.Bundle

class MenuActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    private val btnCasual by lazy { binding.btnCasual }
    private val btnAuthors by lazy { binding.btnAuthors }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            this.supportActionBar?.hide();
        }

        btnCasual.setOnClickListener {
            val intent = Intent(this, LevelSelectionActivity::class.java)
            startActivity(intent)
        }

        btnAuthors.setOnClickListener {
            val intent = Intent(this, AuthorsActivity::class.java)
            startActivity(intent)
        }

    }
}