package com.example.tutoria25_10

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity()
{
    var tvTexto: TextView? = null

    //Con savedInstanceState guardamos el estado de la app
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Rescatar el TextView
        tvTexto = findViewById(R.id.tvTexto) as TextView

        //Rescatar el botón 1 y el botón 2
        val btn1 = findViewById(R.id.button) as Button
        btn1.setOnClickListener{tvTexto?.setText(R.string.texto1)}

        val btn2 = findViewById(R.id.button2) as Button
        btn2.setOnClickListener{
            Toast.makeText(this, R.string.texto2, Toast.LENGTH_LONG).show()}

        val btn3 = findViewById(R.id.button3) as Button
        btn3.setOnClickListener{

            //Creamos el Intent
            val intent: Intent = Intent(this, SegundoActivity::class.java)

            //AlertDialog
            val builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.titulo)
                .setMessage(R.string.alert)
                .setPositiveButton(R.string.start,
                    DialogInterface.OnClickListener
                    {
                        //Se lanza el activity si se pulsa SÍ
                        dialog, id -> startActivity(intent)
                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener
                    {
                            dialog, id -> Toast.makeText(this,
                        "Has cancelado el paso a SegundoActivity",
                        Toast.LENGTH_LONG).show()
                    })

            // Creamos el AlertDialog y lo lanzamos
            builder.create()
            builder.show()
        }
    }
}