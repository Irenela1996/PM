package com.example.irene_lopez_aguado_tarea_pmdm02.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_perfil, container, false)

        var usuario: TextInputLayout = view.findViewById(R.id.outlinedTF_Nombre)
        //Le asignamos la variable de usuarios
        val sharedPref = view.context.getSharedPreferences(getString(R.string.log_preference_file_key), Context.MODE_PRIVATE)

        //Recuperamos el valor almacenado en LoginActivity
        //Como primer valor le asignamos la variable de usuario
        //como valor por defecto usa valor_por_defecto que es "user"
        val user = sharedPref.getString(getString(R.string.log_key), getString(R.string.log_key))

        // Ya tengo el valor del nombre guardado en la variable user del fichero de "usuarios.xml"
        usuario.editText?.setText(user)

        //Devuelve esa vista con la información que ha rescatado
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
        fun newInstance(param1: String, param2: String) =
            FragmentPerfil().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}