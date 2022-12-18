package com.example.irene_lopez_aguado_tarea_pmdm02.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.irene_lopez_aguado_tarea_pmdm02.R
import com.example.irene_lopez_aguado_tarea_pmdm02.fragments.FragmentMisActividades
import com.example.irene_lopez_aguado_tarea_pmdm02.fragments.FragmentPerfil
import com.example.irene_lopez_aguado_tarea_pmdm02.fragments.FragmentReservas
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            //Para crear el menu Botton Navigation View
            // Instanciamos el Botton Navigation Menu
            val bnv = findViewById(R.id.main_bottom_Navigation_View) as BottomNavigationView

            bnv.setOnItemSelectedListener({ item ->
                when (item.itemId) {
                    R.id.page_1 -> {
                        cargarFragments(FragmentPerfil())
                        true
                    }
                    R.id.page_2 -> {
                        cargarFragments(FragmentReservas())
                        true
                    }
                    R.id.page_3 -> {
                        cargarFragments(FragmentMisActividades())
                        true
                    }
                    else -> false
                }
            })
        }

        private fun cargarFragments(fragment: Fragment) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            //Coge el fragment que te estoy dando como parámetro y ponmelo en el framelayout
            fragmentTransaction.add(R.id.main_frameLayout, fragment)
            fragmentTransaction.commit()

        }
    }
