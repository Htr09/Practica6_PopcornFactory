package icedo.hector.popcornfactory_icedohector

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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


        val bundle = intent.extras
        var ns =0
        var id =-1
        var titulo: String? =""
        var sinopsis: String? =""
        var header: Int =0


        var seatsLeft : TextView = findViewById(R.id.seatsLeft)
        val buyTickets : Button = findViewById(R.id.buyTickets)
        val headerImage: ImageView = findViewById(R.id.movie_header)
        val movieTitle: TextView = findViewById(R.id.movie_title_detail)
        val sinopsisText: TextView = findViewById(R.id.movie_summary)


        if(bundle != null){
            ns = bundle.getInt("numberSeats")
            titulo = bundle.getString("titulo")
            sinopsis = bundle.getString("sinopsis")
            header = bundle.getInt("header")
            seatsLeft.setText("$ns seats available")
            id = bundle.getInt("pos")

            movieTitle.text = titulo
            sinopsisText.text = sinopsis
            headerImage.setImageResource(header)
        }

        if(ns == 0){
            buyTickets.isEnabled = false
        }else{
            buyTickets.isEnabled = true
            buyTickets.setOnClickListener {
                val intent : Intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("name", titulo)
                startActivity(intent)

            }
        }

    }
}