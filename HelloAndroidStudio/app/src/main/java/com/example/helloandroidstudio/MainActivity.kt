package com.example.helloandroidstudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //LLamada al constructor
        super.onCreate(savedInstanceState)
        //Método que hace que se muestre por pantalla
        // la interfaz gráfica asociada a un layout concreto
        // El método R llama a activity_main de la carpeta layout
        setContentView(R.layout.activity_main)

        // log que da acceso al log de entorno de desarrolllo y d escribe un mensaje
        // el tag permite asociar todos los mensajes a una etiqueta
        Log.d("HolaMundo", "onCreate")

        val myValue: String? = savedInstanceState?.getString("myKey","I've been saved!")

        if(myValue != null){
            Toast.makeText(this, myValue, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("HolaMundo", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("HolaMundo", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("HolaMundo", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("HolaMundo", "onStop")
    }

    //Para almacenar el estado de nuestra app
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("myKey","I've been saved!")
    }

}