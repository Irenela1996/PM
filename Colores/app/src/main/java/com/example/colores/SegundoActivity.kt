package com.example.colores

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class SegundoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segundo)

        //Rescatamos los botones
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)

        //para el boton 4 vamos a crear un snackbar
        btn4.setOnClickListener {
            //El conexto en este caso es it, que es el mismo, necesita para ejecutarse un objeto snackbar
            val snackbar =
                Snackbar.make(it, "this is a simple Snackbar", Snackbar.LENGTH_LONG).show()
        }


        btn5.setOnClickListener {
            //Creamos el intent
            // le indicamos el contexto "this" y el activity al que quiero llegar
            val intent: Intent = Intent(this, MainActivity::class.java)
            //lanzamos el método para que me lleve al mainActivity
            startActivity(intent)
        }

        btn6.setOnClickListener {
            //Creamos el intent
            // le indicamos el contexto "this" y el activity al que quiero llegar
            val intent: Intent = Intent(this, MainActivityFragments::class.java)
            //lanzamos el método para que me lleve al mainActivity
            startActivity(intent)
        }
    }
}