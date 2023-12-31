import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.squeares.MainActivity2
import com.example.squeares.R

class SquareAdapter(private val squares: List<SquareModel>) :
    RecyclerView.Adapter<SquareAdapter.SquareViewHolder>() {

    class SquareViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val squareView: View = itemView.findViewById(R.id.squareView)
        val numberTextView: TextView = itemView.findViewById(R.id.numberTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SquareViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_square, parent, false)
        return SquareViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SquareViewHolder, position: Int) {
        val squareView = holder.squareView
        if (position % 2 == 0) {
            squareView.setBackgroundResource(R.drawable.square_red)
        } else {
            squareView.setBackgroundResource(R.drawable.square_blue)
        }

        // Установка номера на TextView
        val numberTextView = holder.numberTextView
        numberTextView.text = (position).toString()
        squareView.setOnClickListener {
            val context = holder.itemView.context
            val square = squares[position] // Получаем модель квадрата для текущей позиции

            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra("number", position) // Передаем номер квадрата

            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return squares.size
    }
}