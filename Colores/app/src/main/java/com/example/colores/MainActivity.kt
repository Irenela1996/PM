package com.example.colores

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.colores.fragments.FragmentFav
import com.example.colores.fragments.FragmentHome
import com.example.colores.fragments.FragmentLocation
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    var tvTexto: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Rescatar el TextView en una constante
        tvTexto = findViewById<TextView>(R.id.tvTexto)

        //Rescatamos el botón 1, 2 y 3
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)

        //MOSTRAR UN TOAST
        btn2.setOnClickListener {
            (Toast.makeText(this, R.string.texto2, Toast.LENGTH_LONG).show())
        }

        btn3.setOnClickListener {
            //Creamos el intent
            // le indicamos el contexto "this" y el activity al que quiero llegar
            val intent: Intent = Intent(this, SegundoActivity::class.java)

            //Instanciamos una variable de AlertDialog con builder dentro del contexto "this"
            val builder = AlertDialog.Builder(this)
            //le asignamos un título y el mensaje del tipo alert
            builder.setTitle(R.string.titulo).setMessage(R.string.alert)
                //le asignamos que es lo que queremos que pase en caso afirmativo
                .setPositiveButton(R.string.start, DialogInterface.OnClickListener {
                    //Se lanza el activity si se pulsa SÍ
                    // este es el método que permite cambiar de activity
                        dialog, id ->
                    startActivity(intent)
                    //le asignamos que es lo que queremos que pase en caso negativo
                }).setNegativeButton(R.string.cancel, DialogInterface.OnClickListener {
                    //Se lanza el activity si se pulsa NO
                        dialog, id ->
                    Toast.makeText(
                        this, "Has cancelado el paso a SegundoActivity", Toast.LENGTH_LONG
                    ).show()
                })
            //Creamos dicha variable
            builder.create()
            // La mostramos
            builder.show()


        }
        // Usando lambda
        btn1.setOnClickListener { tvTexto?.setText(R.string.texto1) }
//        btn2.setOnClickListener { tvTexto?.setText(R.string.texto2) }


        //No haciendo el evento con lambda
        //Inicializamos los Listeners de los botones 1 y 2
        //btn1.setOnClickListener(this)
        //btn2.setOnClickListener(this)

        //Para crear el menu Botton Navigation View
        // Instanciamos el Botton Navigation Menu
        val bnv = findViewById<BottomNavigationView>(R.id.botton_navigation_menu)


        bnv.setOnItemSelectedListener({ item ->
            when (item.itemId) {
                R.id.page_1 -> {
                    cargarFragments(FragmentHome())
                    true
                }
                R.id.page_2 -> {
                    cargarFragments(FragmentFav())
                    true
                }
                R.id.page_3 -> {
                    cargarFragments(FragmentLocation())
                    true
                }
                else -> false
            }
        })
    }

//     Una forma de actuar sobre los eventos:
//    //p0 es como args[0] de java. En este caso, hace alusión
//    // al elemento al que se le ha hecho click
//    override fun onClick(p0: View?) {
//        if (p0 != null) {
//            if(p0.id == R.id.btn1) {
//                // Vamos a llegar aquí si hacemos click en botón1
//                tvTexto?.setText(R.string.texto1)
//            }else if(p0.id == R.id.btn2){
//                // Vamos a llegar aquí si hacemos click en botón1
//                tvTexto?.setText(R.string.texto2)
//            }
//        }
//
//    }

    private fun cargarFragments(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        //Coge el fragment que te estoy dando como parámetro y ponmelo en el framelayout
        fragmentTransaction.add(R.id.frameLayout_main, fragment)
        fragmentTransaction.commit()

    }

}