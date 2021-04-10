package ph.edu.benilde.matchingkitties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.edu.benilde.matchingkitties.databinding.ActivityAuthorsBinding

class AuthorsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthorsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Remove title bar
        if (supportActionBar != null) {
            this.supportActionBar?.hide();
        }


    }
}