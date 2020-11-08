package com.example.appcartera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.ListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val manager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmenInicio()

        btnInicio.setOnClickListener {
            fragmenInicio()
        }
        btnIngresar.setOnClickListener {
            fragmenIngresar()
        }

        btnGastos.setOnClickListener {
            fragmenGasto()
        }
        btnMovimiento.setOnClickListener {
            fragmenDatos()
        }
    }

    fun fragmenInicio() {
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.frameInicio, FragmentInicio())
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun fragmenIngresar() {
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.frameInicio, FragmentIngresar())
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun fragmenGasto() {
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.frameInicio, FragmentGasto())
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun fragmenDatos() {
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.frameInicio, FragmentList())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}