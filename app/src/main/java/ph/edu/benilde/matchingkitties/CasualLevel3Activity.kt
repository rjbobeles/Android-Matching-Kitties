package ph.edu.benilde.matchingkitties
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import ph.edu.benilde.matchingkitties.databinding.ActivityLevel3Binding

private const val LOG_TAG = "CasualLevel3"



class CasualLevel3Activity:AppCompatActivity() {
    private lateinit var binding: ActivityLevel3Binding
    private lateinit var buttons: List<ImageButton>
    private val imageButton3A by lazy{binding.imageButton3A}
    private val imageButton3B by lazy{binding.imageButton3B}
    private val imageButton3C by lazy{binding.imageButton3C}
    private val imageButton3D by lazy{binding.imageButton3D}
    private val imageButton3E by lazy{binding.imageButton3E}
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityLevel3Binding.inflate(layoutInflater)
        setContentView(R.layout.activity_level3)

        val image = mutableListOf(R.drawable.kitty_01,R.drawable.kitty_02,R.drawable.kitty_03)

        image.addAll(image)
        image.shuffle()
        buttons = listOf(imageButton3A,imageButton3B,imageButton3C,imageButton3D,imageButton3E)
        buttons.forEachIndexed { index, buttons->
            buttons.setOnClickListener{
                Log.i(LOG_TAG, "image flipped!!")
                buttons.setImageResource(image[index])

            }

        }


    }
}