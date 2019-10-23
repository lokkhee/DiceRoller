package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{ rollDice()}
        val countUpButton : Button = findViewById(R.id.countUp_button)
        countUpButton.setOnClickListener { countUp() }
    }


    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)

        if (resultText.text == "Hello World!") {
            resultText.text = "1"
        } else {
            var resultInt = resultText.text.toString().toInt()

            if (resultInt < 6) {
                resultInt++
                resultText.text = resultInt.toString()
            }
        }
    }

    private fun rollDice(){
        val diceImage: ImageView = findViewById(R.id.dice_image)
        val dice2Image: ImageView = findViewById(R.id.dice2_image)

        diceImage.setImageResource(getRandomDiceImage())
        dice2Image.setImageResource(getRandomDiceImage())

        Toast.makeText(this,"button clicked", Toast.LENGTH_SHORT).show()
        //val resultText: TextView = findViewById(R.id.result_text)
        //resultText.text = randomInt.toString()
    }

    private fun getRandomDiceImage() : Int {
        val randomInt = Random().nextInt(6) + 1

        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}
