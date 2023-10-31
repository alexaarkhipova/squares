package com.example.squeares

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import GridSpacingItemDecoration
import SquareAdapter
import SquareModel

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: SquareAdapter
    private val squares = mutableListOf<SquareModel>() // Список квадратов

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        adapter = SquareAdapter(squares)

        val spanCount = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 4 else 3
        val layoutManager = GridLayoutManager(this, spanCount)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(GridSpacingItemDecoration(resources.getDimensionPixelSize(R.dimen.spacing)))

        recyclerView.adapter = adapter

        val addButton: Button = findViewById(R.id.addButton)
        addButton.setOnClickListener {
            // Создание нового квадрата
            val newSquare = SquareModel()
            squares.add(newSquare)
            adapter.notifyItemInserted(squares.size - 1)
        }

        // Восстановление данных при перевороте экрана
        if (savedInstanceState != null) {
            val savedSquares = savedInstanceState.getParcelableArrayList<SquareModel>("squares")
            if (savedSquares != null) {
                squares.clear()
                squares.addAll(savedSquares)
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("squares", ArrayList(squares))
    }
}