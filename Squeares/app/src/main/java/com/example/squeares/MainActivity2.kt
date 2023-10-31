package com.example.squeares

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val number = intent.getIntExtra("number", 0) // Получаем переданный номер квадрата
        val numberTextView = findViewById<TextView>(R.id.numberTextView)

        // Устанавливаем номер в TextView
        numberTextView.text = number.toString()

        // Устанавливаем фон в зависимости от четности number
        if (number % 2 == 0) {
            numberTextView.setBackgroundResource(R.drawable.square_red)
        } else {
            numberTextView.setBackgroundResource(R.drawable.square_blue)
        }
    }
}