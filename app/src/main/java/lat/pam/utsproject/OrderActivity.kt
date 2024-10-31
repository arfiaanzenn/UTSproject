package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        val FoodNames = findViewById<TextView>(R.id.etFoodName)
        val OrderButton = findViewById<Button>(R.id.btnOrder)
        val NumOfServe = findViewById<EditText>(R.id.etServings)
        val OrderName = findViewById<EditText>(R.id.etName)
        val AddNotes = findViewById<EditText>(R.id.etNotes)
        FoodNames.text = intent.getStringExtra("food_name")

        OrderButton.setOnClickListener {
            val OrderDetails = Intent(this@OrderActivity , ConfirmationActivity::class.java).apply{
                putExtra("Num_of_serve", "Number of Servings :  ${NumOfServe.text.toString()} pax")
                putExtra("OrderName", "Ordering Name : ${OrderName.text.toString()}")
                putExtra("AddtionalNote", " Additional Notes : ${AddNotes.text.toString()}")
                putExtra("Food_Name", "Food Name : ${FoodNames.text}")
            }
            startActivity(OrderDetails)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}