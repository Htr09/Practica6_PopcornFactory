package icedo.hector.popcornfactory_icedohector

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TicketSummary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_summary)

        val movieTitle: TextView = findViewById(R.id.movieTitleSummary)
        val seat: TextView = findViewById(R.id.seatSummary)

        val customerNameInput: EditText = findViewById(R.id.customerNameInput)
        val confirmPurchaseButton: Button = findViewById(R.id.confirmPurchaseButton)

        val movieName = intent.getStringExtra("name")
        val seatNumber = intent.getStringExtra("seat")

        movieTitle.text = "Movie: $movieName"
        seat.text = "Seat: $seatNumber"

        confirmPurchaseButton.setOnClickListener {
            val customerName = customerNameInput.text.toString().trim()
            if (customerName.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Thanks $customerName! Your seat $seatNumber is booked.", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)
                finish()
            }
        }

    }
}