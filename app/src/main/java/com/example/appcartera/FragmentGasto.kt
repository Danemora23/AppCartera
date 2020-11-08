package com.example.appcartera

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.appcartera.Database.User
import com.example.appcartera.Database.UserViewModel
import kotlinx.android.synthetic.main.fragment_gasto.*
import kotlinx.android.synthetic.main.fragment_gasto.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FragmentGasto : Fragment() {

    private lateinit var mUserViewModel1: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_gasto, container, false)
        mUserViewModel1 = ViewModelProvider(this).get(UserViewModel::class.java)

        view.btnGuardarGasto.setOnClickListener {
        gasto()
        }

        return view
    }

    fun gasto(){
        val descripcionGas = txtDescriGastos.text.toString()
        val cantidadGas = Integer.parseInt(txtCantidadGasto.text.toString())
        val fechaGas = Integer.parseInt(txtfechaGasto.text.toString())
        val horaGas = Integer.parseInt(txtHoraGasto.text.toString())

        if(checkGasto(descripcionGas, txtCantidadGasto.text, txtfechaGasto.text, txtHoraGasto.text)) {
            val user1 = User(0, descripcionGas, cantidadGas, fechaGas, horaGas)
            mUserViewModel1.addUser(user1)
            Toast.makeText(requireContext(), "Ingresado", Toast.LENGTH_LONG).show()
        }
    }
   private fun checkGasto(descriGasto: String, cantiGasto: Editable, fechaGasto: Editable, horaGasto: Editable):Boolean{
       return !(TextUtils.isEmpty(descriGasto) && cantiGasto.isEmpty() && fechaGasto.isEmpty() && horaGasto.isEmpty())

   }
}