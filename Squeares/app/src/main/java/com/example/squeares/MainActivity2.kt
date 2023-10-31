package com.example.squeares

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val squareColorResId = intent.getIntExtra("squareColorResId", 0)
        val number = intent.getIntExtra("number", 0)

        // Устанавливаем фон в соответствии с squareColorResId
        if (squareColorResId != 0) {
            findViewById<View>(R.id.squareBackgroundView).setBackgroundResource(squareColorResId)
        }

        // Устанавливаем номер
        findViewById<TextView>(R.id.numberTextView).text = number.toString()
    }
}