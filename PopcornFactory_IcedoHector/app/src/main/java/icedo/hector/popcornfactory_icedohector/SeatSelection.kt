package icedo.hector.popcornfactory_icedohector

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SeatSelection : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seat_selection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val title : TextView = findViewById(R.id.titleSeats)
        var posMovie = -1

        val bundle = intent.extras

        if(bundle!=null){
            title.setText(bundle.getString("name"))
            posMovie = bundle.getInt("id")

        }

        val confirm: Button = findViewById(R.id.confirm)

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)

        confirm.setOnClickListener {
            val selectedSeat: String? = listOf(row1, row2, row3, row4).mapNotNull { group ->
                val checkedId = group.checkedRadioButtonId
                if (checkedId != -1) {
                    findViewById<RadioButton>(checkedId).text.toString()
                } else null
            }.firstOrNull()

            if (selectedSeat == null) {
                Toast.makeText(this, "Please select a seat", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, TicketSummary::class.java)
                intent.putExtra("name", title.text.toString())
                intent.putExtra("id", posMovie)
                intent.putExtra("seat", selectedSeat)
                startActivity(intent)
            }
        }


        row1.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId> -1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                row1.check(checkedId)
            }
        }

        row2.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId> -1){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                row2.check(checkedId)
            }
        }

        row3.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId> -1){
                row1.clearCheck()
                row2.clearCheck()
                row4.clearCheck()
                row3.check(checkedId)
            }
        }

        row4.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId> -1){
                row1.clearCheck()
                row2.clearCheck()
                row3.clearCheck()
                row4.check(checkedId)
            }
        }
    }
}
