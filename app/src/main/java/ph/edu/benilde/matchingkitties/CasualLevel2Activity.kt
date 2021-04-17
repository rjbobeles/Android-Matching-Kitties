package ph.edu.benilde.matchingkitties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import ph.edu.benilde.matchingkitties.databinding.ActivityLevel2Binding


private const val LOG_TAG = "CasualLevel2"


class CasualLevel2Activity: AppCompatActivity(){
    private lateinit var binding: ActivityLevel2Binding
    private lateinit var buttonslvl2: List<ImageButton>
    private val ImageButtonlvl2A by lazy {binding.ImageButtonlvl2A}
    private val ImageButtonlvl2B by lazy {binding.ImageButtonlvl2B}
    private val ImageButtonlvl2C by lazy{binding.ImageButtonlvl2C}
    private val ImageButtonlvl2D by lazy{binding.ImageButtonlvl2D}


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityLevel2Binding.inflate(layoutInflater)
        setContentView(R.layout.activity_level2)

        val images2 = mutableListOf(R.drawable.kitty_01,R.drawable.kitty_02,R.drawable.kitty_03)

        images2.addAll(images2)
        images2.shuffle()
        buttonslvl2 = listOf(ImageButtonlvl2A,ImageButtonlvl2B,ImageButtonlvl2C,ImageButtonlvl2D)
        buttonslvl2.forEachIndexed { index, buttonslvl12->
            buttonslvl12.setOnClickListener{
                Log.i(LOG_TAG, "image flipped!!")
                buttonslvl12.setImageResource(images2[index])

            }

        }


    }

}
