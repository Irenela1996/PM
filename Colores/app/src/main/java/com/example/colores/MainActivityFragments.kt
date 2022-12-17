package com.example.colores

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.colores.fragments.FragmentDos
import com.example.colores.fragments.FragmentUno

class MainActivityFragments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragments)

        //Cargar el fragmento 1 de primeras
        var numFragment=1
        cargarFragments(FragmentUno())

        val btn_cambiar_fragments = findViewById(R.id.btn_cambiar_fragment) as Button

        //Al pulsar el botón, se va alternando el fragment
        btn_cambiar_fragments.setOnClickListener {
            if(numFragment == 1){
                cargarFragments(FragmentDos())
                numFragment=2
            }else if(numFragment == 2){
                cargarFragments(FragmentUno())
                numFragment=1
            }
        }

    }

    private fun cargarFragments(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        //Coge el fragment que te estoy dando como parámetro y ponmelo en el framelayout
        fragmentTransaction.add(R.id.frameLayout, fragment)
        fragmentTransaction.commit()

    }
}