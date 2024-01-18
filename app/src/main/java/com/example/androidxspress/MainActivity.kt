package com.example.androidxspress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText: EditText = findViewById(R.id.editNumber)
        val txtResult: TextView = findViewById(R.id.txtResult)
        val buttonResult: Button = findViewById(R.id.buttonNumber)
        // aqui se localiza funções do button

        buttonResult.setOnClickListener {
            val text = editText.text.toString()
            numbGenerator(text, txtResult)
        }

    }
    private fun numbGenerator(text: String, txtResult: TextView){
    if (text.isNotEmpty()){
        val qtd = text.toInt()
        if (qtd >= 6 && qtd <= 15){
            val numbers = mutableSetOf<Int>()
            val random = java.util.Random()

            while (true) {
                val number = random.nextInt(60)
                numbers.add(number + 1 )

                if (numbers.size == qtd) {
                    break
                }
            }
            txtResult.text = numbers.joinToString("-")



        } else {
            Toast.makeText(this, "Digite um número entre 6 e 15", Toast.LENGTH_LONG).show()
        }

    } else{
        Toast.makeText(this, "Digite um número entre 6 e 15", Toast.LENGTH_LONG).show()
    }


    }


}
