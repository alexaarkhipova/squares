package com.example.squeares
import GridSpacingItemDecoration
import SquareAdapter
import SquareModel
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: SquareAdapter
    private val squares = mutableListOf<SquareModel>() // Список квадратов

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        adapter = SquareAdapter(squares)
        recyclerView.layoutManager = GridLayoutManager(this,
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 4 else 3)
        recyclerView.adapter = adapter

        val addButton: Button = findViewById(R.id.addButton)
        addButton.setOnClickListener {
            // Определение цвета в зависимости от четности элемента
            val colorResId = if (squares.size % 2 == 1) R.color.red else R.color.blue

            // Создание нового квадрата с указанием цвета
            val newSquare = SquareModel(colorResId)
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
        recyclerView.addItemDecoration(GridSpacingItemDecoration(3))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("squares", ArrayList(squares))
    }
    }




