package icedo.hector.popcornfactory_icedohector

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_detail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val imageHeader: ImageView = findViewById(R.id.image_header)
        val textTitle: TextView = findViewById(R.id.text_title)
        val textSinopsis: TextView = findViewById(R.id.text_sinopsis)


        val titulo = intent.getStringExtra("titulo")
        val sinopsis = intent.getStringExtra("sinopsis")
        val header = intent.getIntExtra("header", 0)


        imageHeader.setImageResource(header)
        textTitle.text = titulo
        textSinopsis.text = sinopsis
    }
}