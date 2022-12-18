package com.example.irene_lopez_aguado_tarea_pmdm02.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
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

            val intent = Intent(this@SplashActivity,
                LoginActivity::class.java)

            startActivity(intent)

            finish()
        }, 3000)

    }
}
