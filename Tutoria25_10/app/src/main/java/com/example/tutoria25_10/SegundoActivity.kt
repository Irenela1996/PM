package com.example.tutoria25_10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class SegundoActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segundo)

        //Rescatamos los botones
        val btn4 = findViewById(R.id.button4) as Button

        btn4.setOnClickListener {
            val snack = Snackbar.make(it,
                "This is a simple Snackbar", Snackbar.LENGTH_LONG)
            snack.show()
        }

        val btn5 = findViewById(R.id.button5) as Button

        btn5.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}