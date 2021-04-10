package ph.edu.benilde.matchingkitties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Remove title bar
        setContentView(R.layout.activity_splash_screen)
        if (supportActionBar != null) {
            this.supportActionBar?.hide();
        }

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }, 4500)

        setContentView(R.layout.activity_splash_screen)
    }
}