package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val loginButton=findViewById<Button>(R.id.btnLogin)
        val usr = findViewById<EditText>(R.id.etUsername)
        val pwd = findViewById<EditText>(R.id.etPassword)

        loginButton.setOnClickListener {
            if (usr.text.toString() == "Udin" && pwd.text.toString() == "123"){
                val toListOfFood = Intent(this@MainActivity , ListFoodActivity::class.java)
                startActivity(toListOfFood)
            }
            else{
                Toast.makeText(this,"Username atau Password salah!", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}