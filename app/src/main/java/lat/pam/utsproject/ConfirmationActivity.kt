package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        val confFoodName = findViewById<TextView>(R.id.etconfFood)
        val confNumServe = findViewById<TextView>(R.id.etconfServe)
        val confUserName = findViewById<TextView>(R.id.etconfUsername)
        val confAddnotes = findViewById<TextView>(R.id.etconfaddNotes)
        val buttontoList = findViewById<Button>(R.id.backtoMenu)
        confFoodName.text = intent.getStringExtra("Food_Name")
        confNumServe.text = intent.getStringExtra("Num_of_serve")
        confUserName.text = intent.getStringExtra("OrderName")
        confAddnotes.text = intent.getStringExtra("AddtionalNote")

        buttontoList.setOnClickListener{
            val returnss = Intent(this@ConfirmationActivity , ListFoodActivity::class.java)
            startActivity(returnss)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}