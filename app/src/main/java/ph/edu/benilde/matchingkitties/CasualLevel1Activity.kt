package ph.edu.benilde.matchingkitties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import ph.edu.benilde.matchingkitties.databinding.ActivityLevel1Binding


private const val LOG_TAG = "CasualLevel1"


class CasualLevel1Activity: AppCompatActivity(){
    private lateinit var binding: ActivityLevel1Binding
    private lateinit var buttons: List<ImageButton>
    private val imageButton1 by lazy{binding.imageButton1}
    private val imageButton2 by lazy{binding.imageButton2}
    private val imageButton3 by lazy{binding.imageButton3}

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityLevel1Binding.inflate(layoutInflater)
        setContentView(R.layout.activity_level1)

        val image = mutableListOf(R.drawable.kitty_01,R.drawable.kitty_02,R.drawable.kitty_03)

        image.addAll(image)
        image.shuffle()
        buttons = listOf(imageButton1,imageButton2,imageButton3)
        buttons.forEachIndexed { index, buttons->
            buttons.setOnClickListener{
                Log.i(LOG_TAG, "image flipped!!")
                buttons.setImageResource(image[index])

            }

        }


    }

}
