package com.example.irene_lopez_aguado_tarea_pmdm02.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.irene_lopez_aguado_tarea_pmdm02.R
import com.google.android.material.textfield.TextInputLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentPerfil.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentPerfil : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_perfil, container, false)
        var nombre: String = ""
        var apellido: String = ""

        //Cojo los valores de nombre y apellidos del usuario
        var outlined_usuario: TextInputLayout = view.findViewById(R.id.outlinedTF_Nombre)
        val input_usuario = outlined_usuario.editText?.text.toString()

        var outlined_apellidos: TextInputLayout = view.findViewById(R.id.outlinedTF_apellidos)
        val input_apellidos = outlined_apellidos.editText?.text.toString()

        //Le asignamos la variable de usuarios.xml (el documento de SharedPreferences)
        val sharedPref =
            view.context.getSharedPreferences(getString(R.string.log_key), Context.MODE_PRIVATE)

        //Recuperamos el valor almacenado en LoginActivity
        //Como primer valor le asignamos la variable de email
        val usuario_email = sharedPref.getString(getString(R.string.fp_nombre), "Usuario")
        val apellido_email = sharedPref.getString(getString(R.string.fp_apellidos), "Apellido")

        outlined_usuario.editText?.setText(usuario_email)
        if(!apellido_email.isNullOrEmpty()){
            outlined_apellidos.editText?.setText(apellido_email)
        }

        val btn_guardar = view.findViewById(R.id.btn_guardar) as Button

        btn_guardar.setOnClickListener {
            outlined_usuario.editText?.doOnTextChanged { input_usuario, _, _, _ ->
                //Respond to input text change
                nombre = input_usuario.toString()
            }
            outlined_apellidos.editText?.doOnTextChanged { input_apellidos, _, _, _ ->
                //Respond to input text change
                apellido = input_apellidos.toString()
            }

            if (!nombre.isNullOrEmpty() || !apellido.isNullOrEmpty()) {

                if (!nombre.isNullOrEmpty()) {
                    with(sharedPref.edit()) {
                        putString(getString(R.string.fp_nombre), nombre)
                        apply()
                        Toast.makeText(context, "Se ha guardado el nombre!", Toast.LENGTH_LONG)
                            .show()
                    }
                }
                if (!apellido.isNullOrEmpty()) {
                    with(sharedPref.edit()) {
                        putString(getString(R.string.fp_apellidos), apellido)
                        apply()
                        Toast.makeText(context, "Se ha guardado el apellido!", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }else{
                Toast.makeText(context, "No se ha podido guardar :(", Toast.LENGTH_LONG)
                    .show()
            }
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentPerfil.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = FragmentPerfil().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }

    protected fun leerStringSharePreferences(
        archivo: String, clave: String
    ): String? {
        //Recuperamos la informacion del archivo de SharePreferences
        val sharePref = this.context?.getSharedPreferences(archivo, Context.MODE_PRIVATE)
        // Cargamos un valor desde el fichero de SharePreferences
        return sharePref?.getString(clave, clave)
    }


}