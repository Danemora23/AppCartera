package com.example.appcartera

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.appcartera.Database.User
import com.example.appcartera.Database.UserViewModel
import kotlinx.android.synthetic.main.fragment_ingresar.*
import kotlinx.android.synthetic.main.fragment_ingresar.view.*
import kotlinx.android.synthetic.main.fragment_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FragmentIngresar : Fragment() {
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_ingresar, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.btnIngresoGuardar.setOnClickListener {
         ingresar()
        }
        return view
    }

    fun ingresar(){
        val descripcion = txtDescripcionIngreso.text.toString()
        val cantidad = Integer.parseInt(txtCantidadIngreso.text.toString())
        val fecha = Integer.parseInt(txtFechaIngeso.text.toString())
        val hora = Integer.parseInt(txtHoraIngreso.text.toString())
        if(check(descripcion, txtCantidadIngreso.text, txtFechaIngeso.text, txtHoraIngreso.text)){
            val user = User(0, descripcion, cantidad, fecha, hora)
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Ingresado", Toast.LENGTH_LONG).show()
        }
    }
    private fun check(descri: String, canti: Editable, fecha: Editable, hora: Editable):Boolean{
        return !(TextUtils.isEmpty(descri) && canti.isEmpty() && fecha.isEmpty() && hora.isEmpty())
    }


}