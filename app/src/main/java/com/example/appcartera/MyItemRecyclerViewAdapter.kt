package com.example.appcartera

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.appcartera.Database.User

import com.example.appcartera.dummy.DummyContent.DummyItem
import kotlinx.android.synthetic.main.fragment_list.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(

) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {
    private var values: List<User> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        holder.itemView.txtIdLis.text = item.id.toString()
        holder.itemView.txtDescripcionLis.text = item.descripcion
        holder.itemView.txtCantidadList.text = item.cantidad.toString()
        holder.itemView.txtFechaList.text = item.fecha.toString()
        holder.itemView.txtHoraList.text = item.hora.toString()
    }
    fun setData(users: List<User>){
        this.values = users
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}