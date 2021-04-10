package ph.edu.benilde.matchingkitties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AuthorsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Remove title bar
        setContentView(R.layout.activity_authors)
        if (supportActionBar != null) {
            this.supportActionBar?.hide();
        }

        setContentView(R.layout.activity_authors)
    }
}