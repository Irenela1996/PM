package com.example.irene_lopez_aguado_tarea_pmdm02.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.widget.doOnTextChanged
import com.example.irene_lopez_aguado_tarea_pmdm02.R
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    lateinit var user:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnEntrar = findViewById(R.id.log_btn_entrar) as Button

        ///Leemos al usuario
        var usuario: TextInputLayout = findViewById(R.id.outlinedTF_Usuario) as TextInputLayout
        var inputText = usuario.editText?.text.toString()

        usuario.editText?.doOnTextChanged(){
            inputText, _, _, _ ->
                //Respond to input text change
            user = inputText.toString()
        }
        //Terminamos de leer usuario
        btnEntrar.setOnClickListener{
            /*SHAREDPREFERENCES*/
            //Accedemos la fichero SharedPreferences
            val sharedPref = applicationContext.getSharedPreferences(getString(R.string.log_preference_file_key), Context.MODE_PRIVATE)

            //Guardar un valor en el fichero de SharedPreferences por medio del editor de SharedPreferences
            with(sharedPref.edit()) {
                putString(getString(R.string.log_key), user)
                apply() //Escribe en el fichero de manera asíncrona (para no bloquear el hilo main)
            }

            val intent = Intent(this@LoginActivity, MainActivity::class.java)

            startActivity(intent)
        }
    }
}