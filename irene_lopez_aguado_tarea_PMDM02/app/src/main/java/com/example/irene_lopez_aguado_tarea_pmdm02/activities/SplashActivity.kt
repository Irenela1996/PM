package com.example.irene_lopez_aguado_tarea_pmdm02.activities

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.irene_lopez_aguado_tarea_pmdm02.R


class SplashActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Comprobamos que haya un nombre del usuario almacenado en SharedPreferences
        // eso significa que ya hay una persona loggeada y no hace falta mostrar todo
        // el rato el splashactivity

        Handler(Looper.getMainLooper()).postDelayed({
            if (is_null_or_empty(getString(R.string.log_key),getString(R.string.log_usuario),"")) {
                val intent = Intent(
                    this@SplashActivity, LoginActivity::class.java
                )
                startActivity(intent)
            } else {
                val intent = Intent(
                    this@SplashActivity, MainActivity::class.java
                )
                startActivity(intent)
            }
            finish()
        }, 3000)
    }

    protected fun is_null_or_empty(nombreArchivoXml:String, nombreElementoDentroXml:String, elementoDefault:String) :Boolean {
        return leerStringSharePreferences(
            nombreArchivoXml,
            nombreElementoDentroXml,
            elementoDefault
        ).isNullOrEmpty()
    }

    protected fun leerStringSharePreferences(
        archivo: String,
        clave: String,
        defaultValue: String
    ): String? {
        //Recuperamos la informacion del archivo de SharePreferences
        val sharePref = applicationContext.getSharedPreferences(archivo, Context.MODE_PRIVATE)
        // Cargamos un valor desde el fichero de SharePreferences
        return sharePref.getString(clave, defaultValue)
    }


}
